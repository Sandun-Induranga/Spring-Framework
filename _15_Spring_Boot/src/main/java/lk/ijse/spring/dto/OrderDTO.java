package lk.ijse.spring.dto;

import java.util.List;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class OrderDTO {
    private String orderId;
    private String cusId;
    private double cost;
    private String orderDate;
    private List<OrderDetailDTO> orderDetails;

    public OrderDTO(String orderId, String cusId, double cost, String orderDate, List<OrderDetailDTO> orderDetails) {
        this.orderId = orderId;
        this.cusId = cusId;
        this.cost = cost;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }

    public OrderDTO() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", cusId='" + cusId + '\'' +
                ", cost=" + cost +
                ", orderDate='" + orderDate + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
