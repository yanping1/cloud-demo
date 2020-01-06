package demo.serve.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import demo.serve.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName:
 * @Description:(please write your description)
 * @author: {开发人的姓名}
 * @date:
 * @Copyright: 成都电科惠安
 */
@Service
public class TestService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService ;

    @HystrixCommand(fallbackMethod = "testFallBack")
//    @GlobalTransactional
//    @GlobalLock
    @Transactional
    public String testService() {
            restTemplate.getForEntity("http://TEST/test/getInfo", String.class).getBody();
            String s =restTemplate.getForEntity("http://TEST-CLOUD/test/getInfo", String.class).getBody();
            User user = new User();
            user.setUsername("李军");
            user.setPassword("456");
            user.setName("lijun");
            userService.insert(user);

        return "成功";
    }

    public String testFallBack() {

        return "服务繁忙，请稍后";
    }
}
