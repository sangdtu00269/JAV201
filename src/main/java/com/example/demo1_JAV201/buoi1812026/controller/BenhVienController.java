package com.example.demo1_JAV201.buoi1812026.controller;

import com.example.demo1_JAV201.buoi1812026.model.BenhVien;
import com.example.demo1_JAV201.buoi1812026.repository.BenhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "benhVienController", value = {
        "/benh-vien/hien-thi",
        "/benh-vien/view-update",
        "/benh-vien/xoa",
        "/benh-vien/them",
        "/benh-vien/sua",
})
public class BenhVienController extends HttpServlet {
    BenhVienRepository benhVienRepository = new BenhVienRepository();

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
        benhVienRepository.xoaBenhVien(id);
        resp.sendRedirect("/benh-vien/hien-thi");
    }

    private void viewUPD(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        BenhVien bv = benhVienRepository.getById(id);
        req.setAttribute("bv",bv);
        req.getRequestDispatcher("/buoi1812026-benhVien/view-update.jsp").forward(req,resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listBenhVien",benhVienRepository.getAll());
        req.getRequestDispatcher("/buoi1812026-benhVien/hien-thi.jsp").forward(req,resp);
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
        String tenBenhVien = req.getParameter("tenBenhVien");
        String diaChi = req.getParameter("diaChi");

        BenhVien bv = new BenhVien(id,tenBenhVien,diaChi);
        benhVienRepository.suaBenhVien(bv);

        resp.sendRedirect("/benh-vien/hien-thi");
    }

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenBenhVien = req.getParameter("tenBenhVien");
        String diaChi = req.getParameter("diaChi");

        BenhVien bv = new BenhVien(null,tenBenhVien,diaChi);
        benhVienRepository.themBenhVien(bv);

        resp.sendRedirect("/benh-vien/hien-thi");
    }
}