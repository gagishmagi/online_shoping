/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.dao;

import java.entity.Category; 
import java.entity.Order;
import java.entity.Product;
import java.entity.SubCategory;

import java.entity.Users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.NewHibernateUtil;

/**
 *
 * @author gagi
 */
public class DeleteDao {
    
    public boolean deleteCatagory(Category cat) {
        try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.delete(cat);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteSubCatagory(SubCategory subcat) {
        try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.delete(subcat);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteProduct(Product product) {
        try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean deleteOrder(Order order) {
        try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteUser(Users user) {
        try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
