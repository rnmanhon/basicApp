package pubSub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private static final  Logger LOGGER = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisMessageListenerContainer redisContainer;
    
    @Autowired
    private MessageListenerAdapter messageListener;
    
	
    public void listenTo(Topic topic) {
    	redisContainer.addMessageListener(messageListener, topic);
    	LOGGER.info("redisService listen to topic ..." + topic.getTopic());
    }
    	

}
