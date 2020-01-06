package demo.feign.service;

import demo.feign.api.UserFacade;
import demo.feign.entity.User;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName:
 * @Description:(please write your description)
 * @author: {开发人的姓名}
 * @date:
 * @Copyright: 成都电科惠安
 */
@Service
public class FeignServiceImpl implements FeignService{
    @Resource
    private UserService userService;
    @Resource
    private UserFacade userFacade;


    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    @GlobalLock
    @Transactional(rollbackFor = Exception.class)
    public void insertUser(User user) {
        User user1= userFacade.insertUser(user);
        Integer user2 = userService.insert(user);
        String result1 = userFacade.insertUser();
        String[] a= null ;
        int result = a.length;
        return;
    }
}
