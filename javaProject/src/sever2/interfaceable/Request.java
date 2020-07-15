package sever2.interfaceable;

import java.util.Map;

public interface Request {
    public String getMethod();
    public String getUrl();
    public String getProtocol();//协议版本
    public Map<String,String> getreqHead();
    public Map<String,String> reqBody();
}
