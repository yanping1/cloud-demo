package demo.serve.controllers;

import demo.serve.entity.User;
import demo.serve.service.TestService;
import demo.serve.service.UserService;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName:
 * @Description:(please write your description)
 * @author: {开发人的姓名}
 * @date:
 * @Copyright: 成都电科惠安
 */
@RestController
@RequestMapping("/test")
public class TestController  {
    private Log logger = LogFactory.getLog(TestController.class);
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;
    @Autowired
    private TestService testService;
    @GetMapping(value = "/getInfo")
    @ApiOperation(value = "查询申请相关信息")
    @GlobalTransactional
    @GlobalLock
    @Transactional
    public String getInfo( ) {

        restTemplate.getForEntity("http://TEST/test/getInfo",String.class).getBody();
        restTemplate.getForEntity("http://TEST-CLOUD/test/getInfo",String.class).getBody();
        User user = new User();
        user.setUsername("李军");
        user.setPassword("456");
        user.setName("lijun");
        userService.insert(user);
        String [] l =null;
        if (l.length>5){

        }
//        return testService.testService();
        return "操作成功";
    }
}
