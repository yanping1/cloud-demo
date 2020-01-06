package demo.feign.config;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeataConfiguration {
    @Value("${spring.application.name}")
    private String applicationId;

    /**
     * 注册一个StatViewServlet
     *
     * @return global transaction scanner
     */
//    @Bean
//    public GlobalTransactionScanner globalTransactionScanner() {
//        GlobalTransactionScanner globalTransactionScanner = new GlobalTransactionScanner(applicationId,
//                "my_group");
//        return globalTransactionScanner;
//    }
}
/**
 * @ClassName:
 * @Description:(please write your description)
 * @author: {开发人的姓名}
 * @date:
 * @Copyright: 成都电科惠安
 */