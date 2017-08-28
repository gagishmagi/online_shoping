package entity;
// Generated 08/07/2017 8:14:19 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Order generated by hbm2java
 */
public class Order  implements java.io.Serializable {


     private Integer orderId;
     private DeliveryCost deliveryCost;
     private OrderDetail orderDetail;
     private Users users;
     private Date orderDate;
     private int orderQty;
     private double totalPrice;
     private String orderStatus;
     private Set orderDetails = new HashSet(0);

    public Order() {
    }


    public Order(DeliveryCost deliveryCost, OrderDetail orderDetail, Users users, Date orderDate, int orderQty, double totalPrice, String orderStatus) {
        this.deliveryCost = deliveryCost;
        this.orderDetail = orderDetail;
        this.users = users;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }
    public Order(DeliveryCost deliveryCost, OrderDetail orderDetail, Users users, Date orderDate, int orderQty, double totalPrice, String orderStatus, Set orderDetails) {
       this.deliveryCost = deliveryCost;
       this.orderDetail = orderDetail;
       this.users = users;
       this.orderDate = orderDate;
       this.orderQty = orderQty;
       this.totalPrice = totalPrice;
       this.orderStatus = orderStatus;
       this.orderDetails = orderDetails;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public DeliveryCost getDeliveryCost() {
        return this.deliveryCost;
    }

    public void setDeliveryCost(DeliveryCost deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
    public OrderDetail getOrderDetail() {
        return this.orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public int getOrderQty() {
        return this.orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }
    public double getTotalPrice() {
        double per = this.totalPrice * 17; // Total price + calculated MAAM
        per = per / 100;
        return this.totalPrice + per;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Set getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails(Set orderDetails) {
        this.orderDetails = orderDetails;
    }




}


