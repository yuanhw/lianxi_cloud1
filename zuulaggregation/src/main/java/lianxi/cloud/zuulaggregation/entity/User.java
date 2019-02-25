package lianxi.cloud.zuulaggregation.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/18 11:03
 */
@Data
public class User {
    public User() {
    }

    public User(Long id, String userName, String name, Integer age, BigDecimal balance) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    private Long id;

    private String userName;

    private String name;

    private Integer age;

    private BigDecimal balance;
}
