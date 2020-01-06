package demo.test.controllers;

import demo.test.entity.User;
import demo.test.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:
 * @Description:(please write your description)
 * @author: {开发人的姓名}
 * @date:
 * @Copyright: 成都电科惠安
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController  {
    private Log logger = LogFactory.getLog(TestController.class);


    @Autowired
    private UserService userService;


    @GetMapping(value = "/getInfo")
    @ApiOperation(value = "查询申请相关信息")
    //项目配置了事务处理切面，可不加使用注解
//    @Transactional
    public String getInfo( ) {
        User user = new User();
        user.setName("李四");
        user.setPassword("123");
        user.setUsername("ping");
        userService.insert(user);
        return "888添加成功";
    }

}
