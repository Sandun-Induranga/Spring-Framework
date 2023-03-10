package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/five")
public class EController {




                    //    Wild Card Mapping    -->    *

    //    *    -    One or more characters can replace with this
    /** At least One **/


    @GetMapping(path = "/path/*/A/B")
    public String testOne(){
        return "Method Invoked";
    }




                    //    Dual Wild Card Mapping    -->    *

    //    *    -    Zero or more Segments can replace with this
    /** Zero **/


    @GetMapping(path = "/path/**/A/B")
    public String testTwo(){
        return "Method Invoked";
    }

}
