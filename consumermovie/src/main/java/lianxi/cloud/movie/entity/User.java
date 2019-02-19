package lianxi.cloud.movie.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/18 11:03
 */
@Data
public class User {
    private Long id;

    private String userName;

    private String name;

    private Integer age;

    private BigDecimal balance;
}
