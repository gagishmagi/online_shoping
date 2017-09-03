/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.add_handler;

import java.dao.AddDao;
import java.dao.ListDao;
import java.entity.Product;
import java.entity.SubCategory;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author gagi
 */
@ManagedBean
@SessionScoped
public class ProductManager implements Serializable{

    Product product = new Product();
    SubCategory subcat = new SubCategory();
    String subcatname, catname;
    List<SubCategory> listSubCat;
    UploadedFile image;

    public UploadedFile getImage() {
        return image;
    }

    public void setImage(UploadedFile image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public List<SubCategory> getListSubCat() {
        return listSubCat;
    }

    public void setListSubCat(List<SubCategory> listSubCat) {
        this.listSubCat = listSubCat;
    }

    public SubCategory getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCategory subcat) {
        this.subcat = subcat;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public String addProduct() {
        upload();
        listSubCat = new ListDao().SubcatListByName(catname);
        subcat.setSubCatId(listSubCat.get(0).getSubCatId());
        System.out.println("Subcat Name:" + subcat.getSubCatName());
        product.setSubCategory(subcat);
        product.setProdName(product.getProdName());
        product.setProdQty(product.getProdQty());
        product.setProdPrice(product.getProdPrice());
        product.setProdUrl(product.getProdUrl());
        product.setProdDesc(product.getProdDesc());
        boolean status = new AddDao().addProduct(product);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Product added", 
                                     "Product added to the database sucessfully"
                    )
            );
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_WARN, "Producted wasn't added",
                            "Something wen't wrong Product database failed"
                            + " to add the product!"
                    )
            );
        }
        return null;
    }
    
   public String editProduct(Product p){
       upload();
       
       
       return null;
   }

    public void upload() {
        if (image != null) {
            try {
                //System.out.println("in upload!!!-------------------");
                //System.out.println("Image name: "+image.getFileName());
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletcontext = (ServletContext) context.getExternalContext().getContext();
                String dbpath = servletcontext.getRealPath("/");
                System.out.println("dbpath: " + dbpath);
                String webcut = dbpath.substring(0, dbpath.lastIndexOf(File.separator));
                String buildcut = webcut.substring(0, webcut.lastIndexOf(File.separator));
                String mainURLPath = buildcut.substring(0, buildcut.lastIndexOf(File.separator));
                
                InputStream inputStream = image.getInputstream();
                //String path = mainURLPath + "/web/resources/images/"
                String path = mainURLPath + File.separator+"web"+File.separator + 
                              "resources"+ File.separator +"images"+ File.separator
                        + image.getFileName();
                System.out.println("Full image path: "+path);
                File destFile = new File(path);
                if (!destFile.exists()) {
                    FileUtils.copyInputStreamToFile(inputStream, destFile);
                }
                //product.setProdUrl(image.getFileName().toString());
                product.setProdUrl(image.getFileName().toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<SelectItem> getCategoryName() {
        List<SelectItem> catname = new ListDao().catList();
        return catname;
    }

    public List<SelectItem> getSubCatName() {
        List<SelectItem> subcatname = new ListDao().SubcatList(catname);
        return subcatname;
    }
}
