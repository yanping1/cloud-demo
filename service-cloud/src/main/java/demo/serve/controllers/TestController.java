package demo.serve.controllers;

import demo.serve.entity.User;
import demo.serve.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName:
 * @Description:(please write your description)
 * @author: {开发人的姓名}
 * @date:
 * @Copyright: 成都电科惠安
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController  {
    private Log logger = LogFactory.getLog(TestController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getInfo")
    @ApiOperation(value = "查询申请相关信息")
    @Transactional
    public String getInfo( ) {
        logger.info("进入了张三控制器");
        User user = new User();
        user.setEmail("1822117257@qq.com");
        user.setName("张三");
        user.setPassword("123");
        user.setUsername("yan");
        userService.insert(user);
        return "8080添加成功";
    }
    @ApiOperation(value = "添加")
    @PostMapping(value = "/insertUser")
    public User insertUser(@RequestBody User user){
        userService.insert(user);
        return user;
    }

//    @ApiOperation(value = "添加")
//    @PostMapping(value = "/insertUser")
//    public User insertUser(@RequestParam("userId") String userId){
//        userService.
//        return user;
//    }

}
