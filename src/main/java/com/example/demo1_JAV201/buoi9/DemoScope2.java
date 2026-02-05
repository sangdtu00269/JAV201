package com.example.demo1_JAV201.buoi9;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "demoScope2", value = {
        "/demo-scope-2"
})
public class DemoScope2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //request scope
        String requestMessage = (String) req.getAttribute("requestMessage");
        System.out.println(requestMessage);

        //session scope
        HttpSession session = req.getSession();
        String sessionMessage = (String) session.getAttribute("sessionMessage");
        System.out.println(sessionMessage);

        //application scope
        ServletContext servletContext = getServletContext();
        String applicationMessage = (String) servletContext.getAttribute("applicationMessage");
        System.out.println(applicationMessage);

        req.getRequestDispatcher("/buoi9/hien-thi.jsp").forward(req,resp);
    }
}
