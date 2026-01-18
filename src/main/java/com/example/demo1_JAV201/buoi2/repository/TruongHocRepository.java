package com.example.demo1_JAV201.buoi2.repository;

import com.example.demo1_JAV201.buoi2.model.TruongHoc;
import com.example.demo1_JAV201.buoi2.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class TruongHocRepository {
    private Session session = null; //phien truy cap vao csdl

    public TruongHocRepository(){
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<TruongHoc> getAll(){
        return session.createQuery("SELECT th FROM TruongHoc th").list();
    }

    public TruongHoc getById(Integer id) {
        return session.find(TruongHoc.class, id);
    }

    public void themTruongHoc(TruongHoc truongHoc) {
        try {
            session.getTransaction().begin();
            session.save(truongHoc);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void suaTruongHoc(TruongHoc truongHoc) {
        try {
            session.getTransaction().begin();
            session.merge(truongHoc);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void xoaTruongHoc(Integer id) {
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
