package server.req_respo_interface;

import java.util.Map;

public interface Request {
    public String getMethod();
    public String getUrl();
    public String getProtocol();
    public Map<String,String> getReqHead();
    public Map<String,String> reqBody();
}
