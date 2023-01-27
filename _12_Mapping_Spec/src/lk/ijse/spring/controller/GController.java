package lk.ijse.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/seven")
public class GController {

    /* There are two parts in a request
     *       1. Header(Metadata)
     *       2. Body
     * */

//    @GetMapping
//    public String testOne() {
//        return "Method Invoked 1";
//    }

//    @GetMapping(produces = {"Application/json"})
////    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public String testTwo() {
//        return "Method Invoked 2";
//    }

//    @GetMapping(consumes = {"text/html"})
////    @GetMapping(consumes = {MediaType.TEXT_HTML_VALUE})
//    public String testThree() {
//        return "Method Invoked 3";
//    }

//    @GetMapping(produces = {"text/html"})
////    @GetMapping(consumes = {MediaType.TEXT_HTML_VALUE})
//    public String testFour() {
//        return "Method Invoked 3";
//    }

    /*
     *       consume    =    Content-Type
     *       produces   =    Accept - Default (all)
     *
     *
     *
     *       Content-Type    -    What are the content type of the request body
     *       Accept    -    What type we want from the response
     *
     * */

    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
//    @GetMapping(consumes = {MediaType.TEXT_HTML_VALUE})
    public String testFour() {
        return "Method Invoked 4";
    }

}
