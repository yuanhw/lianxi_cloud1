package lianxi.cloud.provideuser.controller;

import lianxi.cloud.provideuser.dao.UserDao;
import lianxi.cloud.provideuser.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/18 10:52
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            userDetails.getAuthorities().forEach(auth -> logger.info("当前用户是{}，角色是{}", userDetails.getUsername(), auth.getAuthority()));
        }
        return this.userDao.findOne(id);
    }
}
