package demo.test.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author liq
 * @Title: User
 * @ProjectName lcn-demo
 * @Description: TODO
 * @date 2019-06-0409:11
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String username;
    private String password;
}
