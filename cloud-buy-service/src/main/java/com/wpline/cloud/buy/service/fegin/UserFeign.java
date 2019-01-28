package com.wpline.cloud.buy.service.fegin;

import com.wpline.cloud.buy.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "cloud-user-service", fallback = UserFeignFallBack.class)
public interface UserFeign {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);

    @GetMapping("/users/first/{time}")
    User getById(@PathVariable("time") Long time);
}

@Component
@Slf4j
class UserFeignFallBack implements UserFeign {

    @Override
    public User findById(Long id) {
        log.error("hystrix：Fegin调用findById失败回调");
        return new User(id, "默认用户findById", "默认用户findById", 0, new BigDecimal(1));
    }

    @Override
    public User getById(Long id) {
        log.error("hystrix：Fegin调用getById失败回调");
        return new User(id, "默认用户getById", "默认用户getById", 0, new BigDecimal(1));
    }
}
