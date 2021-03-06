package java.entity;
// Generated 08/07/2017 8:14:19 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UserRole generated by hbm2java
 */
public class UserRole  implements java.io.Serializable {


     private Integer roleId;
     private String roleName;
     private Set userses = new HashSet(0);

    public UserRole() {
    }

	
    public UserRole(String roleName) {
        this.roleName = roleName;
    }
    public UserRole(String roleName, Set userses) {
       this.roleName = roleName;
       this.userses = userses;
    }
   
    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Set getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set userses) {
        this.userses = userses;
    }




}


