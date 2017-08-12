/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import dao.ListDao;
import entity.Product;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author gagi
 */
@ManagedBean
@SessionScoped
public class DisplayProductManager2 implements Serializable {

    Product product = new Product();
    private String param;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public List<Product> getAllProductByCatName() {
        //System.out.println(param.toLowerCase() + "--------------");
        List<Product> plist = new ListDao()
                .ProductListByCatName(param.toLowerCase());
        return plist;
    }
}
