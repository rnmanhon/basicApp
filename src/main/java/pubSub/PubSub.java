package pubSub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PubSub {
    private static final  Logger LOGGER = LoggerFactory.getLogger(PubSub.class);

	public static void main(String[] args) {
		System.out.println("Initializing Spring context.");
		LOGGER.info("Initializing Spring context.");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/application-context.xml");
		DummyService service= (DummyService) applicationContext.getBean("dummyService");
		service.test();

	}

}
