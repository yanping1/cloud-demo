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
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController  {
    private Log logger = LogFactory.getLog(TestController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getInfo")
    @ApiOperation(value = "查询申请相关信息")
    @Transactional
//    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    public String getInfo( ) {
        logger.info("进入了王5控制器");
        User user = new User();
        user.setName("王5");
        user.setPassword("123");
        user.setUsername("yan");
        userService.insert(user);
        return "8085添加成功";
    }

    @ApiOperation(value = "添加")
    @PostMapping(value = "/insertUser")
    public User insertUser(@RequestBody User user){
        userService.insert(user);
        return user;
    }
}
