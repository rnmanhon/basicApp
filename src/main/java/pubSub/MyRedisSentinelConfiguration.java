package pubSub;

import java.util.Set;

import org.springframework.data.redis.connection.RedisSentinelConfiguration;

public class MyRedisSentinelConfiguration extends RedisSentinelConfiguration {
	/* this class is used to solve the Spring 3.x issue on generic Java type */
	
	public void setMySentinels(Set sentinels) {	
		this.setSentinels(sentinels);
	}
}
