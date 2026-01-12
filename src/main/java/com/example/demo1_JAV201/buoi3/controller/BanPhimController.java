package com.example.demo1_JAV201.buoi3.controller;

import com.example.demo1_JAV201.buoi3.model.BanPhim;
import com.example.demo1_JAV201.buoi3.repository.BanPhimRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BanPhimController", value = {
        "/ban-phim/hien-thi",
        "/ban-phim/view-update",
        "/ban-phim/xoa",
        "/ban-phim/them",
        "/ban-phim/sua"
})
public class BanPhimController extends HttpServlet {
    BanPhimRepository banPhimRepository = new BanPhimRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if (uri.contains("view-update")) {
            viewUPD(req,resp);
        } else if(uri.contains("xoa")){
            xoa(req,resp);
        }
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        banPhimRepository.xoaBanPhim(id);
        resp.sendRedirect("/ban-phim/hien-thi");
    }

    private void viewUPD(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        BanPhim bp = banPhimRepository.getByID(id);
        req.setAttribute("bp_detail",bp);
        req.getRequestDispatcher("/buoi3/view-update.jsp").forward(req,resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listBanPhim", banPhimRepository.getAll());
        req.getRequestDispatcher("/buoi3/hien-thi.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("them")) {
            them(req, resp);
        } else if (uri.contains("sua")) {
            sua(req,resp);
        }
    }

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenBanPhim = req.getParameter("tenBanPhim");
        Boolean tinhTrang = Boolean.valueOf(req.getParameter("tinhTrang"));
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        BanPhim bp = new BanPhim(null,tenBanPhim,tinhTrang,gia,soLuong);
        banPhimRepository.themBanPhim(bp);
        resp.sendRedirect("/ban-phim/hien-thi");
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenBanPhim = req.getParameter("tenBanPhim");
        Boolean tinhTrang = Boolean.valueOf(req.getParameter("tinhTrang"));
        Float gia = Float.valueOf(req.getParameter("gia"));
        Integer soLuong = Integer.valueOf(req.getParameter("soLuong"));
        BanPhim bp = new BanPhim(id,tenBanPhim,tinhTrang,gia,soLuong);
        banPhimRepository.suaBanPhim(bp);
        resp.sendRedirect("/ban-phim/hien-thi");
    }
}
