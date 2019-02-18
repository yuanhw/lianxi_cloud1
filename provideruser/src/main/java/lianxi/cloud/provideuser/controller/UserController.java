package lianxi.cloud.provideuser.controller;

import lianxi.cloud.provideuser.dao.UserDao;
import lianxi.cloud.provideuser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserDao userDao;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return this.userDao.findOne(id);
    }
}
