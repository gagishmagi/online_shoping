/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Product;
import entity.SubCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.NewHibernateUtil;


/**
 *
 * @author gagi
 */
public class AddDao {
    public boolean addCatagory(Category cat){
        try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(cat);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean addSubCatagory(SubCategory subcat){
        try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(subcat);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean addProduct(Product product){
        try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
