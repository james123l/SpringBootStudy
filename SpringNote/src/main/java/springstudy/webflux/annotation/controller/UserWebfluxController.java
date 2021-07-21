package springstudy.webflux.annotation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springstudy.webflux.annotation.entity.UserWebflux;
import springstudy.webflux.annotation.service.UserWebfluxService;


/*
* WebFlux 基于reactor netty springwebflux
* */
@RestController
public class UserWebfluxController {
    @Autowired
    private UserWebfluxService userService;

    @GetMapping("/user/{id}")
    public Mono<UserWebflux> getUserById(@PathVariable int id){
        return  userService.getUserById(id);
    }
    @GetMapping("/user")
    public Flux<UserWebflux> getAllUsers(){
        return  userService.getAllUser();
    }
    @GetMapping("/saveuser")
    public Mono<Void> saveUser(@RequestBody UserWebflux user ){
        Mono<UserWebflux> userMono = Mono.just(user);
        return  userService.saveUserInfo(userMono);
    }

}
