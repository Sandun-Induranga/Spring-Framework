package lk.ijse.spring.dto;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class ItemDTO {
    String code;
    String name;

    double price;
    int qty;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
    }

    public int getQtyOnHand() {
        return qty;
    }

    public void setQtyOnHand(int qty) {
        this.qty = ItemDTO.this.qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemDTO() {
    }

    public ItemDTO(String code, String name, double price, int qty) {
        this.code = code;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "code='" + code + '\'' +
                ", itemName='" + name + '\'' +
                ", price=" + price +
                ", qtyOnHand=" + qty +
                '}';
    }
}
