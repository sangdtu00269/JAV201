package com.example.demo1_JAV201.buoi1812026.repository;

import com.example.demo1_JAV201.buoi1812026.model.BenhVien;
import com.example.demo1_JAV201.buoi1812026.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class BenhVienRepository {
    private Session session = null;

    public BenhVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<BenhVien> getAll(){
        return session.createQuery("SELECT bv FROM BenhVien bv").list();
    }

    public BenhVien getById(Integer id){
        return session.find(BenhVien.class, id);
    }

    public void themBenhVien(BenhVien bv){
        try{
            session.getTransaction().begin();
            session.save(bv);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void suaBenhVien(BenhVien bv){
        try{
            session.getTransaction().begin();
            session.merge(bv);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void xoaBenhVien(Integer id){
        try{
            session.getTransaction().begin();
            session.delete(this.getById(id));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
