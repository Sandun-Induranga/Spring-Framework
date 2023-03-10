package lk.ijse.spring.repo;


import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@SpringBootTest
@Transactional
class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    void findCustomerByName() {
        ArrayList<Customer> arrayList = customerRepo.findCustomerByName("Dasun");
        for (Customer customer : arrayList) {
            System.out.println(customer);
        }
    }

    @Test
    void findByName() {
        ArrayList<Customer> arrayList = customerRepo.findByName("Dasun");
        for (Customer customer : arrayList) {
            System.out.println(customer);
        }
    }

    @Test
    void testAllMethods() {
        ArrayList<Customer> c = customerRepo.findCustomerByName("Dasun");
        ArrayList<Customer> c1 = customerRepo.readCustomerByName("Dasun");
        ArrayList<Customer> c2 = customerRepo.getCustomerByName("Dasun");
        ArrayList<Customer> c3 = customerRepo.queryCustomerByName("Dasun");
        ArrayList<Customer> c4 = customerRepo.searchCustomerByName("Dasun");
        ArrayList<Customer> c5 = customerRepo.streamCustomerByName("Dasun");

        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);

        long count = customerRepo.countCustomerByName("Dasun");
        System.out.println(count);

        boolean exists = customerRepo.existsCustomerByAddress("Colombo");
        System.out.println(exists);

//        customerRepo.deleteCustomerByAddress("Colombo");

        ArrayList<Customer> customers = customerRepo.methodOne();
        System.out.println(customers);

        ArrayList<Customer> customers1 = customerRepo.methodTwo();
        System.out.println(customers1);

        ArrayList<Customer> customers2 = customerRepo.methodThree("C001", "John");
        System.out.println(customers2);

        System.out.println(customerRepo.getCustomerWithJPQL());

        System.out.println(customerRepo.getCustomerWithHQL());

    }

    @Test
    public void pagingAndSorting() {
        PageRequest of = PageRequest.of(0, 3, Sort.by("salary"));
        Page<Customer> all = customerRepo.findAll(of);
        for (Customer customer : all.toList()) {
            System.out.println(customer);
        }
    }

}
