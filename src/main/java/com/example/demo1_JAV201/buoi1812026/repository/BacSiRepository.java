package com.example.demo1_JAV201.buoi1812026.repository;

import com.example.demo1_JAV201.buoi1812026.model.BacSi;
import com.example.demo1_JAV201.buoi1812026.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class BacSiRepository {
    private Session session = null;

    public BacSiRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<BacSi> getAll(){
        return session.createQuery("SELECT bs FROM BacSi bs").list();
    }

    public BacSi getById(Integer id){
        return session.find(BacSi.class, id);
    }

    public void themBacSi(BacSi bs){
        try{
            session.getTransaction().begin();
            session.save(bs);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void suaBacSi(BacSi bs){
        try{
            session.getTransaction().begin();
            session.merge(bs);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void xoaBacSi(Integer id){
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
