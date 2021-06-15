package in.nareshit.raghu.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import in.nareshit.raghu.consumingrest.Quote;

@Component
public class ConsumingQuoteTest implements CommandLineRunner {
	private static final Logger log=LoggerFactory.getLogger(ConsumingQuoteTest.class);
	
	@Value("${my.app.url}")
	private String url;
	
	@Autowired
	private RestTemplate rt;

	@Override
	public void run(String... args) throws Exception {
			Quote quote = rt.getForObject(url, Quote.class);
			log.info(quote.toString());

	}

}
