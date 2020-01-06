package demo.feign.fallback;

import demo.feign.api.UserFacade;
import demo.feign.entity.User;

/**
 * @ClassName:
 * @Description:(please write your description)
 * @author: {开发人的姓名}
 * @date:
 * @Copyright: 成都电科惠安
 */
public class UserServiceFallBack implements UserFacade {
    @Override
    public String insertUser() {
        return "服务繁忙，请等待";
    }

    @Override
    public User insertUser(User user) {
        return null;
    }
}
