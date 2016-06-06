package pubSub;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RedisPublisherService {
	@Autowired 
    private RedisTemplate< String, Object > template;
    private ChannelTopic topic;
    private final AtomicLong counter = new AtomicLong( 0 );

	public void setTopic(ChannelTopic topic) {
		this.topic = topic;
	}

//	public RedisPublisherService( final RedisTemplate< String, Object > template, 
//            final ChannelTopic topic ) {
//        this.template = template;
//        this.topic = topic;
//    }

//    @Scheduled( fixedDelay = 100 )
    public void publish(String message) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	String currentDate = dateFormat.format(date); //2014/08/06 15:59:48    	
    	
        template.convertAndSend( topic.getTopic(), "Message " + message + " " + counter.incrementAndGet() + 
            " at " + currentDate + ", " + Thread.currentThread().getName() );
 }
}