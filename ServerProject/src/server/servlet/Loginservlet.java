package server.servlet;

import server.req_respo_interface.Request;
import server.req_respo_interface.Response;

import java.io.PrintStream;
import java.util.Map;

public class Loginservlet implements Servlet{
    @Override
    public void reserve(Request req, Response res) {
        PrintStream ps = res.getPs();
        //发送响应到浏览器
        //1.发送响应行
        String resLine = res.getResLine();
        System.out.println("响应行为:" + resLine);
        ps.println(resLine);
        //2.发送响应头
        String resHeader = res.getResHeader();
        System.out.println("响应头为:" + resHeader);
        ps.println(resHeader);
        //3.发送空行
        ps.println();
        //4.发送响应体
        ps.println("<html>");
        ps.println("<head>");
        ps.println("</head>");
        ps.println("<body>");
        ps.println("<h1>");
        Map<String, String> map = req.reqBody();
        String name = map.get("name");
        ps.println(name + "registered successfully!");
        ps.println("</h1>");
        ps.println("</body>");
        ps.println("</html>");
        ps.close();

    }
}
