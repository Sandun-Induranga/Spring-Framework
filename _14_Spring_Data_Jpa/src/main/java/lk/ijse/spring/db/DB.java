package lk.ijse.spring.db;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class DB {

    public static List<CustomerDTO> customerDB = new ArrayList<>();
    public static List<ItemDTO> itemDB = new ArrayList<>();
    public static List<OrderDTO> orderDB = new ArrayList<>();
    public static List<OrderDetailDTO> orderDetailDB = new ArrayList<>();

}
