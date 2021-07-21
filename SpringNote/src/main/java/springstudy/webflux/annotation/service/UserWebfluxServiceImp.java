package springstudy.webflux.annotation.service;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springstudy.webflux.annotation.entity.UserWebflux;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserWebfluxServiceImp implements UserWebfluxService{
    //模拟数据
    private final Map<Integer,UserWebflux> users = new ConcurrentHashMap<>();

    public UserWebfluxServiceImp() {
        this.users.put(1,new UserWebflux("James",27));
        this.users.put(1,new UserWebflux("Jamie",20));
        this.users.put(1,new UserWebflux("Colson",24));
        this.users.put(1,new UserWebflux("Sam",29));
    }

    @Override
    public Mono<UserWebflux> getUserById(int id) {
        //mono的just创建元素
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<UserWebflux> getAllUser() {
        //获取集合 也可以通过数组和流获取（mono flux都可以）
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<UserWebflux> user) {
        //thenEmpty(Mono.empty())终止
        return user.doOnNext(person-> this.users.put(users.size()+1,person)).thenEmpty(Mono.empty());
    }
}
