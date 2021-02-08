package pl.edu.wszib.yourtravel.rest.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.yourtravel.model.User;

@RequestMapping(value = "/api")
@RestController
public class SimpleRestController {

    @RequestMapping(value = "/endpoint1", method = RequestMethod.POST)
    public void endpoint1(@RequestBody User user){
        System.out.println(user);

    }

    @RequestMapping(value = "/endpoint2", method = RequestMethod.GET)
    public void endpoint2(){

    }





}
