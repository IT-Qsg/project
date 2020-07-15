package server.req_resp_Imp;

import Util.logUtil.Log;
import server.req_respo_interface.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RequestImp  implements Request {
    private String getMethod;
    private String getUrl;
    private String getProtocol;
    private Map<String ,String> getReqHead;
    private Map<String ,String> reqBody;

    //扩展属性
    public Socket sc;//公有的是为了响应时用到同一个Socket
    private BufferedReader br;

    public RequestImp(Socket sc) throws IOException {
      this.sc = sc;
      this.br  = new BufferedReader(new InputStreamReader(this.sc.getInputStream()));
        getReqHead = new HashMap<>();
        reqBody = new TreeMap<>();
        reqInfo();
    }
    //获取请求行
    private String reqLine() throws IOException {
        String rline;
        rline = br.readLine();
        if(rline==null) return "0" ;
        return rline;
    }
    //拆分请求行
    private void spReqLine(String reqLine) throws IOException {
        if("0".equals(reqLine)) {Log.logger().info("请求行为空"); return; }
        String[] s = reqLine.split(" ");
        if(s.length!=3) {
            //记录日志，抛出异常
            Log.logger().info("行分割异常");
            throw new IOException("行分割异常");
        }
        this.getMethod = s[0];
        Log.logger().info(getMethod);
        this.getUrl = s[1];
        Log.logger().info(getUrl);
        this.getProtocol = s[2];
    }
    //获得请求头
    private void getHead() throws IOException {
        String readhead;
        while(!(""==(readhead = br.readLine()))){
            String[] split = readhead.split(": ");
            if(split.length!=2){
                if(split.length==1)return;//防止头与体之间的空行
                Log.logger().info("请求头分割异常");
                throw new IOException("请求头分割异常");
            }
            this.getReqHead.put(split[0],split[1]);
        }
    }
    //获得请求体
    private void getBody() throws IOException {
        if(br.ready()){
            //post请求
            String s = br.readLine();
            spBody(s);
        }
        //get 请求
        //是否存在？号
        String s = this.getUrl;
        if(s.contains("?")){
            String[] split = s.split("[?]");
            this.getUrl = split[0];
            if(split.length==1)return;
            spBody(split[1]);
        }else return;
    }
    //分割请求体
    private void spBody(String s){
        String[] split = s.split("&");
        //只有一个'&'时
        if(split.length==0){
            Log.logger().info("请求体只有一个'&'符号");
            return;
        }
        for (String s1 : split) {
            String[] split1 = s1.split("=");
            if(split1.length==1)this.reqBody.put(split1[0],"");
            if(this.reqBody.containsKey(split[0]))return;
            this.reqBody.put(split1[0],split1[1]);
            Log.logger().info(split1[0]);
        }
    }
    public void reqInfo() throws IOException {
        String s = reqLine();
        if("0".equals(s))return;
        spReqLine(s);
        getHead();
        getBody();

    }

    public static void main(String[] args) {
        String ss = "?";
        String[] split = ss.split("\\?");
        for (String s : split) {
            System.out.println(s);
        }
    }
    @Override
    public String getMethod() {
        return getMethod;
    }

    @Override
    public String getUrl() {
        return getUrl;
    }

    @Override
    public String getProtocol() {
        return getProtocol;
    }

    @Override
    public Map<String, String> getReqHead() {
        return getReqHead;
    }

    @Override
    public Map<String, String> reqBody() {
        return reqBody;
    }
}
