package demo.stream.mq;

import demo.stream.StreamApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @ClassName:
 * @Description: mq消息接收者
 * @author: 严平
 * @date: 2019-12-27
 * @Copyright: 成都电科惠安
 */
@EnableBinding(Sink.class)
public class SinkReceiver {
    private static Logger logger= LoggerFactory.getLogger(StreamApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object layload){
        logger.info("接收到的信息"+layload);
    }
}
