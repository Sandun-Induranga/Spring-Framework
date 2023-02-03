package lk.ijse.spring.dto;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class OrderDetailDTO {
    String orderId;
    String code;
    double unitPrice;
    int qty;

    public OrderDetailDTO(String orderId, String code, double unitPrice, int qty) {
        this.orderId = orderId;
        this.code = code;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public OrderDetailDTO() {
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }
}
