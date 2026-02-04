package com.example.demo1_JAV201.tutor5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginController", value = {
        "/login-tutor",
        "/logout"
})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("login-tutor")){
            req.getRequestDispatcher("/tutor5/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        // tai khoan nhan vien: abc - 123
        // tai khoan quan ly: bde - 234
        if(
                username.equals("abc") && password.equals("123")
                || username.equals("bde") && password.equals("234")
        ){
            // tk, mk dung
            if(username.equals("abc")){
                session.setAttribute("role", "nhanvien");
                resp.sendRedirect("/nhan-vien/hien-thi");
            } else if(username.equals("bde")){
                session.setAttribute("role", "quanly");
                resp.sendRedirect("/quan-ly/hien-thi");
            }
        } else {
            // tk, mk sai
            req.setAttribute("message", "Sai thong tin dang nhap");
            req.getRequestDispatcher("/tutor5/hien-thi.jsp").forward(req,resp);
        }
    }
}
