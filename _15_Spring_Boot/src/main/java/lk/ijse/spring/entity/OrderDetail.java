package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@IdClass(OrderItem_PK.class)
public class OrderDetail {

    @Id
    String orderId;
    @Id
    String code;
    double unitPrice;
    int qty;

    @ManyToOne
    @JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false)
    private Orders order;

    //Out-verse
    @ManyToOne
    @JoinColumn(name = "code",referencedColumnName = "code",insertable = false,updatable = false)
    private Item item;

}
