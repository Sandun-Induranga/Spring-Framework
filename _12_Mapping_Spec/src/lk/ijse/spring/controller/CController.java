package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/three")
public class CController {


    //    {id}    ->    Path Variable
    //    id      ->    Path Segment

//    @GetMapping(path = "/id/{id}/{name}")
//    public String testOne(@PathVariable String id, @PathVariable String name){
//
//        return "Get Method Invoked" + id + name;
//    }





    //              Path Variables With RegEX


    @GetMapping(path = "/id/{id:[C]{1}[0-9]{3}}/{name}")
    public String testOne(@PathVariable String id, @PathVariable String name) {

        return "Get Method Invoked" + " " + id + " " + name;

    }

    @GetMapping(path = "/id/{id:[C00-]{4}[0-9]{3}}/{name}")
    public String testTwo(@PathVariable String id, @PathVariable String name) {

        return "Get Method Invoked" + " " + id + " " + name;

    }

}
