package sever2;

import sever2.interfaceable.Request;
import sever2.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class RequestImp implements Request {
    private String reqMethod;//请求方法
    private String reqUrl;   //url
    private String reqProtocol; //协议版本
    private Map<String,String> reqHead; //请求头
    private Map<String,String> reqBody; //请求体(请求消息)

    public RequestImp(String requestLine) {

        //分割请求行
        String[] rl = requestLine.split(" ");
        if(rl.length!=3){
            Log.logger().info("行分割异常");
            try {
                throw new IOException("行分割异常");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.reqMethod = rl[0];
        this.reqProtocol = rl[2];
        //如果带有参数继续分割
        if(rl[1].contains("?")) {
            String[] split = rl[1].split("\\?");
            if(split.length==1)this.reqUrl = split[0];
            else {
                this.reqUrl = split[0];
                //将请求体加入map集合
                String[] split1 = split[1].split("&");
                reqBody = new TreeMap<>();
                for (String s : split1) {
                    String[] split2 = s.split("=");
                    reqBody.put(split2[0], split2[1]);
                }
            }
        }else{
            this.reqUrl = rl[1];
        }


    }

    public void setReqHead(Map<String, String> reqHead) {
        this.reqHead = reqHead;
    }

    public void setReqBody(Map<String, String> reqBody) {
        this.reqBody = reqBody;
    }

    @Override
    public String getMethod() {
        return reqMethod;
    }

    @Override
    public String getUrl() {
        return reqUrl;
    }

    @Override
    public String getProtocol() {
        return reqProtocol;
    }

    @Override
    public Map<String, String> getreqHead() {
        return reqHead;
    }

    @Override
    public Map<String, String> reqBody() {
        return reqBody;
    }
}
class t{
    public static void main(String[] args) {
        String ss = "??dsfks?";
        String[] split = ss.split("\\?");
        for (String s : split) {
            System.out.println(s+"-----");
        }

    }
}