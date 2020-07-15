package sever2;

import sever2.util.Log;
import sever2.util.ProperFindder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;


public class Sevet2 {
  /*  private ServerSocket ss;
    private int port = 100;

    public Sevet2() {
        this.port = Integer.parseInt(ProperFindder.getValudOf("severPort"));
        try {
             ss = new ServerSocket(port);
            Log.logger().info("创建服务器成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void receive(){
        try {
            //获取客户端套接字
            Socket accept = ss.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket ss = new ServerSocket(Integer.parseInt(ProperFindder.getValudOf("severPort")));

        Socket sc = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            //接收请求行并处理
            String requestLine = br.readLine();
            RequestImp requestImp = new RequestImp(requestLine);
            String url = requestImp.getUrl();
            Log.logger().info(url);
            //接收响应头
            String head;
            Map<String, String> headMap = new TreeMap<>();
            //   int i = 1;
            while (!("".equals(head = br.readLine()))) {

                String[] sphead = head.split(": ");
                //将请求头信息存入map集合
                headMap.put(sphead[0], sphead[1]+"</br>");
            }
            requestImp.setReqHead(headMap);
            Map<String, String> stringStringMap = requestImp.reqBody();
            Log.logger().info(stringStringMap);
            PrintStream pr = new PrintStream(sc.getOutputStream(), true);
            File filepath = new File(ProperFindder.getValudOf("Resoutcepath"), url);
            if (filepath.exists()) {
                //文件存在
                pr.println("HTTP/1.1 " + 200 + " " + ProperFindder.getValudOfstatus("200"));
                if ("/".equals(url)) {
                    //返回欢迎页面
                    filepath = new File(ProperFindder.getValudOf("Resoutcepath"),
                            ProperFindder.getValudOf("welFile"));
                }
            } else {
                //不存在发送错误yemian
                //发送响应行
                pr.println("HTTP/1.1 " + 404 + " " + ProperFindder.getValudOfstatus("404"));
                filepath = new File(ProperFindder.getValudOf("Resoutcepath"),
                        ProperFindder.getValudOf("errorFile"));
            }
            //发送响应头
            pr.println("Content-Type: text/html; charset=UTF-8");

            //发送空行
            pr.println();
            //发送内容

            FileInputStream fi = new FileInputStream(filepath);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fi.read(bytes, 0, bytes.length)) != -1) {
                pr.println(new String(bytes, 0, length));
            }
            pr.println("<center><h3>请求体</h3>"+requestImp.reqBody()+"</center></br>");
            pr.println("<center><h3><font color=red>请求头</font></h3></br>"+requestImp.getreqHead()+"</center>");
        }
}
