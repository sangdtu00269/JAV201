package com.example.demo1_JAV201.buoi3.repository;

import com.example.demo1_JAV201.buoi3.util.HibernateConfig;
import com.example.demo1_JAV201.buoi3.model.BanPhim;
import org.hibernate.Session;

import java.util.List;

public class BanPhimRepository {
    private Session session = null;

    public BanPhimRepository(){
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<BanPhim> getAll(){
        return session.createQuery("SELECT bp FROM BanPhim bp").list();
    }

    public BanPhim getByID(Integer id){
        return session.find(BanPhim.class, id);
    }

    public void themBanPhim(BanPhim banPhim){
        try {
            session.getTransaction().begin();
            session.save(banPhim);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void suaBanPhim(BanPhim banPhim){
        try {
            session.getTransaction().begin();
            session.save(banPhim);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void xoaBanPhim(Integer id){
        try {
            session.getTransaction().begin();
            session.delete(this.getByID(id));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
