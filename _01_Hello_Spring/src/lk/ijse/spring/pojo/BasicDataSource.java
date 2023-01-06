package lk.ijse.spring.pojo;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

// Imagine this class is not my class and can't use @Component
public class BasicDataSource {
    public BasicDataSource() {
        System.out.println("BasicDataSource: Instantiated");
    }

    public void getDataSource(){
        System.out.println("DataSource Received");
    }

}
