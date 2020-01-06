//package demo.serve.config;
//
//import com.codingapi.txlcn.common.util.id.ModIdProvider;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * @ClassName:
// * @Description: TC模块在负载时，TM为了区分具体模块，
// * 会要求TC注册时提供唯一标识。
// * 默认策略是，应用名称加端口方式标识。
// * 也可以自定义，
// * 自定义需要保证各个模块标识不能重复。
// * @author: {开发人的姓名}
// * @date:
// * @Copyright: 成都电科惠安
// */
//@Component
////@PropertySource({"classpath:application.yml"})
//public class MyModIdProvider implements ModIdProvider {
//
//    @Value("${erlogin.ip}")
//    private String ip;
//    @Value("${server.port}")
//    private String port;
//    @Override
//    public String modId() {
//        return ip + port;
//    }
//}
