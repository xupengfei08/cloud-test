package com.wpline.cloud.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Title: cloud-test--com.wpline.cloud.buy.UserController
 * @Description:
 * @Author suanmilk
 * @CreateTime: 2019-01-24 20:18
 */
@RequestMapping("/users")
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        try {
            log.info("开始休眠");
            Thread.sleep(20000L);
            log.info("结束休眠");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional<User> result = this.userRepository.findById(id);
        return result;
    }

    @GetMapping("/first/{time}")
    public Optional<User> getById(@PathVariable Long time) {
        try {
            log.info("开始休眠");
            Thread.sleep(time);
            log.info("结束休眠");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional<User> result = this.userRepository.findById(1L);
        return result;
    }
}
