package com.example.demo1_JAV201.demoAjax;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "demoAjaxController", value = {
        "/hien-thi",
        "/api/list",
})
public class DemoAjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")){
            hienThi(req,resp);
        } else if (uri.contains("api/list")){
            getApiList(req,resp);
        }
    }

    private void getApiList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SinhVien sv = new SinhVien(1,"Nguyen Van A", true);
        // Chuyen doi object sang json
        Gson gson = new Gson();
        String data = gson.toJson(sv);
        // Ky hieu goi tin tra ve
        resp.setContentType("application/json");
        // Gui du lieu xuong client
        PrintWriter pw = resp.getWriter();
        pw.print(data);
        pw.flush();
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/demoAjax/hien-thi.jsp").forward(req,resp);
    }
}
