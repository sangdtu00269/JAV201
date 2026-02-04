package com.example.demo1_JAV201.tutor5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "nhanVienController", value = {
        "/nhan-vien/hien-thi"
})
public class NhanVienController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tenWebsite","Nhan vien");
        req.getRequestDispatcher("/tutor5/hien-thi.jsp").forward(req,resp);
    }
}
