package entity;
// Generated 08/07/2017 8:14:19 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private Integer catId;
     private String catName;
     private String catDesc;
     private Set subCategories = new HashSet(0);

    public Category() {
    }

	
    public Category(String catName, String catDesc) {
        this.catName = catName;
        this.catDesc = catDesc;
    }
    public Category(String catName, String catDesc, Set subCategories) {
       this.catName = catName;
       this.catDesc = catDesc;
       this.subCategories = subCategories;
    }
   
    public Integer getCatId() {
        return this.catId;
    }
    
    public void setCatId(Integer catId) {
        this.catId = catId;
    }
    public String getCatName() {
        return this.catName;
    }
    
    public void setCatName(String catName) {
        this.catName = catName;
    }
    public String getCatDesc() {
        return this.catDesc;
    }
    
    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }
    public Set getSubCategories() {
        return this.subCategories;
    }
    
    public void setSubCategories(Set subCategories) {
        this.subCategories = subCategories;
    }




}

