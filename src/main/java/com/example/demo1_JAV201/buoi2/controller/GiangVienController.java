package com.example.demo1_JAV201.buoi2.controller;

import com.example.demo1_JAV201.buoi2.model.GiangVien;
import com.example.demo1_JAV201.buoi2.model.TruongHoc;
import com.example.demo1_JAV201.buoi2.repository.GiangVienRepository;
import com.example.demo1_JAV201.buoi2.repository.TruongHocRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "giangVienController", value = {
        "/giang-vien/hien-thi",
        "/giang-vien/view-update",
        "/giang-vien/xoa",
        "/giang-vien/them",
        "/giang-vien/sua",
})
public class GiangVienController extends HttpServlet {
    GiangVienRepository giangVienRepository = new GiangVienRepository();
    TruongHocRepository truongHocRepository = new TruongHocRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")){
            hienThi(req,resp);
        } else if(uri.contains("view-update")){
            viewUPD(req,resp);
        } else if(uri.contains("xoa")){
            xoa(req,resp);
        }
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        giangVienRepository.xoaGiangVien(id);
        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void viewUPD(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        GiangVien gv = giangVienRepository.getById(id);
        req.setAttribute("gv", gv);
        req.setAttribute("listTruongHoc",truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi4/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listGiangVien",giangVienRepository.getAll());
        req.setAttribute("listTruongHoc",truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            them(req,resp);
        } else if(uri.contains("sua")) {
            sua(req,resp);
        }
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer idTruongHoc = Integer.valueOf(req.getParameter("idTruongHoc"));
        TruongHoc truongHoc = truongHocRepository.getById(idTruongHoc);

        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenGiangVien = req.getParameter("tenGiangVien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        GiangVien giangVien = new GiangVien(id, tenGiangVien,tuoi,gioiTinh,truongHoc);
        giangVienRepository.suaGiangVien(giangVien);

        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer idTruongHoc = Integer.valueOf(req.getParameter("idTruongHoc"));
        TruongHoc truongHoc = truongHocRepository.getById(idTruongHoc);

        String tenGiangVien = req.getParameter("tenGiangVien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        GiangVien giangVien = new GiangVien(null, tenGiangVien,tuoi,gioiTinh,truongHoc);
        giangVienRepository.themGiangVien(giangVien);
        resp.sendRedirect("/giang-vien/hien-thi");
    }
}
