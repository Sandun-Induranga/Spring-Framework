package lk.ijse.spring.entity;

import lk.ijse.spring.dto.OrderDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Order {
    @Id
    private String orderId;
    private String cusId;
    private double cost;
    private String orderDate;
    private List<OrderDetail> orderDetails;
}
