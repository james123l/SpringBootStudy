package springstudy.webflux.annotation.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springstudy.webflux.annotation.entity.UserWebflux;

public interface UserWebfluxService {
    //mono和flux可以返回对象和信号， 信号表示终止，一个流可以不返回信号作为无限流，信号有终止和异常两种
    //mono返回0-1元素
    Mono<UserWebflux> getUserById(int id);
    //flux 返回0-n个参数
    Flux<UserWebflux> getAllUser();
    //无类型使用类型Void
    Mono<Void> saveUserInfo(Mono<UserWebflux> user);
}
