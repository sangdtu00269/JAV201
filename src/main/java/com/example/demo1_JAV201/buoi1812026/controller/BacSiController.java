package com.example.demo1_JAV201.buoi1812026.controller;

import com.example.demo1_JAV201.buoi1812026.model.BacSi;
import com.example.demo1_JAV201.buoi1812026.model.BenhVien;
import com.example.demo1_JAV201.buoi1812026.repository.BacSiRepository;
import com.example.demo1_JAV201.buoi1812026.repository.BenhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "bacSiController", value = {
        "/bac-si/hien-thi",
        "/bac-si/view-update",
        "/bac-si/xoa",
        "/bac-si/them",
        "/bac-si/sua",
})
public class BacSiController extends HttpServlet {
    BenhVienRepository benhVienRepository = new BenhVienRepository();
    BacSiRepository bacSiRepository = new BacSiRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req,resp);
        }else if(uri.contains("view-update")){
            viewUPD(req,resp);
        }else if(uri.contains("xoa")){
            xoa(req,resp);
        }
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        bacSiRepository.xoaBacSi(id);
        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void viewUPD(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        BacSi bs = bacSiRepository.getById(id);
        req.setAttribute("bs",bs);
        req.setAttribute("listBenhVien",benhVienRepository.getAll());
        req.getRequestDispatcher("/buoi1812026-bacSi/view-update.jsp").forward(req,resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listBenhVien",benhVienRepository.getAll());
        req.setAttribute("listBacSi",bacSiRepository.getAll());
        req.getRequestDispatcher("/buoi1812026-bacSi/hien-thi.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            them(req,resp);
        }else if(uri.contains("sua")) {
            sua(req, resp);
        }
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenBacSi = req.getParameter("tenBacSi");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        Integer idBenhVien = Integer.valueOf(req.getParameter("idBenhVien"));
        BenhVien bv = benhVienRepository.getById(idBenhVien);

        BacSi bs = new BacSi(id,tenBacSi,tuoi,gioiTinh,bv);
        bacSiRepository.suaBacSi(bs);

        resp.sendRedirect("/bac-si/hien-thi");
    }

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenBacSi = req.getParameter("tenBacSi");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        Integer idBenhVien = Integer.valueOf(req.getParameter("idBenhVien"));
        BenhVien bv = benhVienRepository.getById(idBenhVien);

        BacSi bs = new BacSi(null,tenBacSi,tuoi,gioiTinh,bv);
        bacSiRepository.themBacSi(bs);

        resp.sendRedirect("/bac-si/hien-thi");
    }
}