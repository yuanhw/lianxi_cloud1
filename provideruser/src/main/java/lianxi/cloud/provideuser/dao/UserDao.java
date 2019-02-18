package lianxi.cloud.provideuser.dao;

import lianxi.cloud.provideuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/18 11:10
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
