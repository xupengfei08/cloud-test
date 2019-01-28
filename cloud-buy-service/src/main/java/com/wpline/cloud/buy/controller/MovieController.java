package com.wpline.cloud.buy.controller;

import com.wpline.cloud.buy.model.User;
import com.wpline.cloud.buy.service.fegin.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: cloud-test--com.wpline.cloud.buy.controller.MovieController
 * @Description:
 * @Author suanmilk
 * @CreateTime: 2019-01-24 20:43
 */
@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable Long id) {
        log.debug("开始请求/user");
        User user = null;
        try {
            user = this.userFeign.findById(id);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
        log.info("结束请求/user");
        return user;
    }

    @GetMapping("/user/id/{id}")
    public User getUserById(@PathVariable Long id) {
        log.debug("开始请求/user/id");
        User user = null;
        try {
            user = this.userFeign.getById(id);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
        log.info("结束请求/user/id");
        return user;
    }
}
