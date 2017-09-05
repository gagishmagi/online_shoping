/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.add_handler;

import java.dao.AddDao; 
import java.dao.DeleteDao;
import java.dao.EditDao;
import java.dao.ListDao;
import java.entity.Order;
import java.entity.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Omer
 */
@ManagedBean
@SessionScoped
public class UsersManager implements Serializable{

    Users user;
    private List<Users> allUsers;

    public UsersManager() {
        user = new Users();
        allUsers = new ArrayList<>();
    }

    public List<Users> allUsers() {
        allUsers = new ListDao().AllUsers();
        return allUsers;

    }


    public Users getUser() {
        return user;
    }

    public void setUsers(Users user) {
        this.user = user;
    }


    public void deleteUser() {
        new DeleteDao().deleteUser(user);
    }

    public int getUserId() {
        return user.getUserId();
    }

}
