package lk.ijse.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class A {

//    @Autowired
    SuperB superB; // Property Injection

//    @Autowired // Constructor Injection
    // Works without this annotation But it's a conversion
    public A(SuperB superB) {
//        this.superB = superB;
        System.out.println("A: Instantiated");
    }

    @Autowired
    public void setInjection(SuperB superB){
        this.superB = superB;
    }

    public void test(){
        superB.methodUseByA();
    }

}
