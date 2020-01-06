package demo.feign.api;

import demo.feign.config.FullLogConfiguration;
import demo.feign.entity.User;
import demo.feign.fallback.UserServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="test-cloud",fallback = UserServiceFallBack.class,configuration = FullLogConfiguration.class)
public interface UserFacade {
    @GetMapping(value = "/test/getInfo")
    String insertUser();

    @PostMapping(value = "/test/insertUser")
    User insertUser(User user);
}
