package lk.ijse.spring.dto;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class OrderDTO {
    String orderId;
    String code;
    double price;
    int qty;

    public OrderDTO(String orderId, String code, double price, int qty) {
        this.orderId = orderId;
        this.code = code;
        this.price = price;
        this.qty = qty;
    }

    public OrderDTO() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
