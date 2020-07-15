package server.ThreadSever;

import server.req_resp_Imp.RequestImp;
import server.req_resp_Imp.ResponImp;

import java.io.IOException;
import java.util.Map;

public class serverRunable implements Runnable {
    private ResponImp resp;
    private RequestImp req;
    public serverRunable(ResponImp resp, RequestImp req) {
        this.resp = resp;
        this.req = req;
    }

    @Override
    public void run() {
        Map<String, String> reqHead = req.getReqHead();
        Map<String, String> stringStringMap = req.reqBody();
        String resLine = resp.getResLine();
        String resHeader = resp.getResHeader();
        try {
            resp.sendResresource();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
