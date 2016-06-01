package pubSub;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DummyService {
    private static final  Logger LOGGER = LoggerFactory.getLogger(DummyService.class);

	
    public void test() {
		System.out.println("DummyService test ...");
    	LOGGER.info("DummyService test ...");
    }
    	

}
