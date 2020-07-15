package Sever3;

import sever2.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class requestImp implements Request {

    Socket sc;
    private String getMethod;
    private String getUrl;
    private String getprotocol;
    private Map<String,String> getreqHead;
    private Map<String,String> reqBody;

    public requestImp (Socket sc) {
        this.sc = sc;
        getreqHead = new TreeMap<>();
        reqBody = new HashMap<>();
        try {
            Log.logger().info(sc.getInetAddress().getHostAddress());
            gerInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void gerInfo() throws IOException {
        //读取请求行
        BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
        String requestLine = br.readLine();
        //拆分请求行
        String[] splitRequest = requestLine.split(" ");
        if(splitRequest.length!=3){
            Log.logger().info("请求行拆分错误");
            throw new IOException("请求行拆分错误");
        }
        //将请求方法与HTTP协议版本赋值
        getMethod = splitRequest[0];
        getprotocol = splitRequest[2];

        Log.logger().info(splitRequest[1]);
        //读取请求头,存入map集合
        String readHead ;
        while(!"".equals(readHead = br.readLine())){
            String[] splitHead = readHead.split(": ");
            Log.logger().info(readHead);
            getreqHead.put(splitHead[0],splitHead[1]);
        };

        //如果是GET请求则拆分URL
        if("GET".equals(getMethod)){
            if(splitRequest[1].contains("?")) {
                String[] splitline = splitRequest[1].split("[?]");//正则表达式
                if (splitline.length != 2) {
                    Log.logger().info("拆分URL错误");
                    throw new IOException("拆分URL错误");
                }
                //获得URL
                this.getUrl = splitline[0];
                //获得请求体
                /*String[] splitBody = splitline[1].split("&");
                for (String s : splitBody) {
                    String[] split = s.split("=");
                    if(split.length!=2){
                        reqBody.put(split[0],"");
                    }
                    reqBody.put(split[0],split[1]);
                }*/
                spString(splitline[1]);

            }else
                this.getUrl = splitRequest[1];

        }/*else{
            //读取post请求体

        }*/
        //如果不为空则为POST请求，读取请求体
        if(br.ready()){
           // Log.logger().info("br.read()");
            //读取请求体
            String readbody;
            while(!((readbody = br.readLine())==null)){
                spString(readbody);
                System.out.println(readbody);
                Log.logger().info("br.read()");
            };
        }

    }
    public void spString(String str){
        String[] splitBody = str.split("&");
        for (String s : splitBody) {
            String[] split = s.split("=");
            if(split.length!=2){
                reqBody.put(split[0],"");
            }
            reqBody.put(split[0],split[1]);
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
        return getprotocol;
    }

    @Override
    public Map<String, String> getReqHead() {
        return getreqHead;
    }

    @Override
    public Map<String, String> reqBody() {
        return reqBody;
    }
}
