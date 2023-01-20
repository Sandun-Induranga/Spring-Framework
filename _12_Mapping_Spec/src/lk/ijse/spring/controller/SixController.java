package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/six")
public class SixController {


//    @GetMapping(params = {"id", "name"})
//    public String testOne(HttpServletRequest request){
//        System.out.println(request.getParameter("id"));
//        return "Method Invoked";
//    }

    @GetMapping(params = {"address", "salary"})
    public String testTwo() {
        return "Method Invoked";
    }




    //    Spring Alternative for req.getParameter("")

    // @RequestParam is not a required annotation

    @GetMapping(params = {"id", "name"})
    public String testOne(@RequestParam String id, @RequestParam String name) {
        System.out.println(id + " " + name);
        return "Method Invoked";
    }

//    @GetMapping(params = {"id", "name"})
//    public String testOne(@RequestParam("id") String myId, @RequestParam("name") String myName) {
//        System.out.println(myId + " " + myName);
//        return "Method Invoked";
//    }

}
