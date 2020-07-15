package Sever3;

import java.util.Map;
public interface Request {
    public String getMethod();
    public String getUrl();
    public String getProtocol();
    public Map<String,String> getReqHead();
    public Map<String,String> reqBody();
}
