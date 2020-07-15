package server.req_resp_Imp;
;
import Util.finder.Finder;
import Util.logUtil.Log;
import server.req_respo_interface.Response;
import server.servlet.Servlet;

import java.io.*;
import java.net.Socket;

public class ResponImp implements Response {
    private Socket sc;
    private String url;
    private String resourcePath;
    private String errorFile;
    private String welFile;
    private PrintStream ps;
    private File file;

    RequestImp req;
    //
    String dynClassName;
    public ResponImp(RequestImp req) throws IOException {
        this.req = req;
        this.sc = req.sc;
        this.url = req.getUrl();
        this.resourcePath = Finder.getValudOfconfig("Resoutcepath");
        this.errorFile = Finder.getValudOfconfig("errorFile");
        this.welFile = Finder.getValudOfconfig("welFile");
        this.ps = new PrintStream(this.sc.getOutputStream(),true);
    }
    //响应行
    @Override
    public String getResLine() {
        if (dynClassName!=null){
            return "HTTP/1.1 200 OK";
        }
        String s;
        this.file = new File(this.resourcePath,this.url);
        if(file.exists()){
            s = "HTTP/1.1 200 "+Finder.getValudOfstatus("200");
            if("/".equals(url)){
                this.file = new File(this.resourcePath,welFile);
            }
        }else{
            s = "HTTP/1.1 404 "+Finder.getValudOfstatus("404");
            this.file = new File(this.resourcePath,errorFile);
        }
        return s;
    }

    //响应头
    @Override
    public String getResHeader() {
        if (dynClassName!=null){
            return "Content-Type: " + Finder.getValudOfmime("html");
        }
        String strHead = null;
        String[] split = url.split("[.]");
        String end = split[split.length-1];
        Log.logger().info("后缀："+end);
        if("".equals(end)){
            Log.logger().info("文件后缀为空");
            try {
                throw new IOException("文件后缀为空");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        strHead ="Content-Type: "+Finder.getValudOfmime(end)+"; charset=UTF-8";
        return strHead;
    }

    //发送响应体
    @Override
    public void sendResBody() throws IOException {

        FileInputStream fi = new FileInputStream(this.getFile());

        byte[] bytes = new byte[1024];
        int length;
        while((length = fi.read(bytes,0,bytes.length))!=-1){
            ps.println(new String (bytes,0,length));
        }
        fi.close();
        ps.close();
    }

    @Override
    public void sendResresource() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        if (isDynam()){
            //利用反射实例化类对象
            Class aClass = Class.forName(dynClassName);
            Log.logger().info("isDynam"+url);
            Servlet s = (Servlet)aClass.newInstance();


            //调用service方法,service中实现将动态页面发送给浏览器
            s.reserve(this.req,this);
        }else {
        String resLine = getResLine();
        //发送相应行
        ps.println(resLine);
        //发送响应头
        String resHeader = getResHeader();
        ps.println(resHeader);
        //发送空行
        ps.println();
        //发送响应体
        sendResBody();}
    }

    //动态获取页面
    public boolean isDynam(){
        //1.判断文件是否存在
        File file = new File(resourcePath, url);
        if (file.exists())
            return false;
        //2.判断是否以.action结尾
        if (url.endsWith(".action") == false)
            return false;
        //3.分割请求的url拿到urlName,判断请求资源是否在配置文件内
        String[] arr = url.split("[.]");
        //login.servlet.action
        if (arr.length != 2)
            return false;
        //       arr[0] = /loginServlet
        String urlName = arr[0].substring(1);

        Log.logger().info(urlName);
        //从配置文件中提取类的全包名
        this.dynClassName =Finder.getValudOfServlet(urlName);
        if (dynClassName == null)
            return false;
        return true;
    }
    @Override
    public PrintStream getPs() {
        return this.ps;
    }
    public File getFile(){
        return this.file;
    }
}
