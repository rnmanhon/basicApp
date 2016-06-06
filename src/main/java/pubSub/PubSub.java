package pubSub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.listener.ChannelTopic;

public class PubSub {
	private static final Logger LOGGER = LoggerFactory.getLogger(PubSub.class);
	public RedisSentinelConfiguration conf;

	public static void main(String[] args) {
		System.out.println("Initializing Spring context.");
		LOGGER.info("Initializing Spring context.");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/application-context.xml");
		RedisService redisService = (RedisService) applicationContext
				.getBean("redisService");

		// maybe autowired the selected topic in real application
		ChannelTopic topic = (ChannelTopic) applicationContext.getBean("topic");
		redisService.listenTo(topic);

		RedisPublisherService redisPublisherService = (RedisPublisherService) applicationContext
				.getBean("redisPublisherService");
		redisPublisherService.setTopic(topic);

		for (int i = 0; i < 1000; ++i) {
			try {
				redisPublisherService.publish("testing");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
