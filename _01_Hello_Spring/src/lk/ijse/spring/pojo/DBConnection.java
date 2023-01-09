package lk.ijse.spring.pojo;

import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component("database")
public class DBConnection {

    public DBConnection() {
        System.out.println("DBConnection: Instantiated");
    }

    public void testConnection(){
        System.out.println("Connection Received");
    }

}
