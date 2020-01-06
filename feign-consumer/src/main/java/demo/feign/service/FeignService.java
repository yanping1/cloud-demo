package demo.feign.service;

import demo.feign.entity.User;

public interface FeignService  {
    /**
     * 添加
     * @param user
     */
    void insertUser(User user);
}
