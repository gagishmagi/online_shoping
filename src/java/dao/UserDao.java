/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import util.NewHibernateUtil;

public class UserDao {

//    public static boolean isUser(String login, String password) throws
//            SQLException {
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            SessionFactory factory = NewHibernateUtil.getSessionFactory();
//            Session session = factory.openSession();
//            
//
//            con = session.doReturningWork(new ReturningWork<Connection>() {
//                @Override
//                public Connection execute(Connection conn) throws SQLException {
//                    return conn;
//                }
//            });
//            //con = Database.getConnection();
////            ps = con.prepareStatement(
////                    "SELECT uname , password from user where uname = ?"
////                    + "and password = ?");
//            ps = con.prepareStatement(
//                    "Select username FROM users WHERE username = 'gagi'");
//            ps.setString(1, login);
//            ps.setString(2, password);
//
//            rs = ps.executeQuery();
//            if (rs.next()) { //found
//                return true;
//            } else {
//                return false;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//
//    }
    
//    private EntityManagerFactory factory = Persistence
//            .createEntityManagerFactory("users");
//    private EntityManager em = factory.createEntityManager();

    SessionFactory factory = NewHibernateUtil.getSessionFactory();
    Session session = factory.openSession();
    
    public Users getUser(String userName, String password) {
        try {
            List<Users> users =  session.createQuery(
                    "SELECT u from Users u where u.username = "
                    + ":name and u.pass = :password"
            )
                    .setParameter("name", userName)
                    .setParameter("password", password)
                    .list();
            if(!users.isEmpty())
                return users.get(0);
            else
                return null;
        } catch (NoResultException e) {
            return null;
        } finally{
            session.close();
        }
    }
    
    

}
