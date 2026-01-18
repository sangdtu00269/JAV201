package com.example.demo1_JAV201.buoi2.repository;

import com.example.demo1_JAV201.buoi2.model.GiangVien;
import com.example.demo1_JAV201.buoi2.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class GiangVienRepository {
    private Session session = null; //phien truy cap vao csdl

    public GiangVienRepository(){
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<GiangVien> getAll(){
        return session.createQuery("SELECT gv FROM GiangVien gv").list();
    }

    public GiangVien getById(Integer id) {
        return session.find(GiangVien.class, id);
    }

    public void themGiangVien(GiangVien giangVien) {
        try {
            session.getTransaction().begin();
            session.save(giangVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void suaGiangVien(GiangVien giangVien) {
        try {
            session.getTransaction().begin();
            session.merge(giangVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void xoaGiangVien(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
