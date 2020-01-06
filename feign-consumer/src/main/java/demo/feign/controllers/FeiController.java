package demo.feign.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.feign.api.UserFacade;
import demo.feign.entity.User;
import demo.feign.fallback.UserServiceFallBack;
import demo.feign.service.FeignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName:
 * @Description:(please write your description)
 * @author: {开发人的姓名}
 * @date:
 * @Copyright: 成都电科惠安
 */
@RestController
@RequestMapping(value = "/feign")
@Api(value = "测试",tags = "测试")
public class FeiController {

    @Resource
    private UserFacade userFacade;

    @Resource
    private FeignService feignService;

    @ApiOperation(value = "查询申请相关信息")
    @GetMapping(value = "/getInfo")
    @HystrixCommand
    public String test(){
        String result =userFacade.insertUser();
        return result;
    }

    @ApiOperation(value = "添加测试提调用")
    @PostMapping(value = "/insert")
    @HystrixCommand
    public User test(@RequestBody User user){
        User result =userFacade.insertUser(user);
        return result;
    }

    @ApiOperation(value = "添加分布式事务调用")
    @PostMapping(value = "/feignAndSeataTest")
    @HystrixCommand
    public User feignAndSeataTest(@RequestBody User user){
        try {
            feignService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return user;
    }

}
