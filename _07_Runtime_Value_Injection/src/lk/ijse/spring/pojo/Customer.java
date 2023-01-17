package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class Customer {

    @Autowired(required = false)
    public Customer(@Value("Dasun, Virat, John") String[] names) {

        for (String name :
                names) {
            System.out.println(name);
        }
    }

//    @Autowired // When use this in a class that have multiple constructors, Run this constructor
//    public Customer(@Value("Dasun") String name){
//        System.out.println(name);
//    }

    @Autowired(required = false)
    // If use @Autowired with required = false in all constructors, Then invoke the constructor that includes most parameters
    public Customer(@Value("Dasun") String name, @Value("]20") int age) {
        System.out.println(name);
    }

    /*

    Data Types can pass to @Value

        Primitive Data Types
        String Data
        Arrays

     */

}
