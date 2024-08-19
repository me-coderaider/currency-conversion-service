package rtg.learning.microservices.currency_conversion_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping(path="/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		CurrencyConversion currencyConversion=new CurrencyConversion(10001L,"USD","INR",quantity,BigDecimal.ONE,BigDecimal.ONE,"");
		String port=environment.getProperty("local.server.port");
		currencyConversion.setEnvironment(port);
		
		return currencyConversion;
	}
}
