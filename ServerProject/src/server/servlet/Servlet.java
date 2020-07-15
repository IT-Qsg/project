package server.servlet;

import server.req_respo_interface.Request;
import server.req_respo_interface.Response;

public interface Servlet {
    void reserve(Request rq, Response rp);
}
