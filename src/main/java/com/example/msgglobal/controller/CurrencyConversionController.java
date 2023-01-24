package com.example.msgglobal.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.msgglobal.service.CurrencyConversionIF;

/**
 * @author Mohammad Arif Ansari
 *
 */
@RestController
@RequestMapping(value = "/msg/api/currency/")
public class CurrencyConversionController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CurrencyConversionIF currencyConvertImpl;
	
	/**
	 * @param currencyFrom
	 * @param currencyTo
	 * @param quantity
	 * @return
	 * @throws JSONException
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@RequestMapping(value = "convertion", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Map<String, String> currencyConvert(
			@RequestParam("CurrencyFrom") String currencyFrom,
			@RequestParam("CurrencyTo") String currencyTo,
			@RequestParam("Quantity") String quantity)
			throws JSONException, MalformedURLException, IOException{
		log.info("Currency converting from {} to {} for amount {}", currencyFrom, currencyTo, quantity);
		Map<String, String> convertedAmount = currencyConvertImpl.currencyConversionService(currencyFrom, currencyTo, quantity);
		log.info("Converted for amount {} - from {} to {} ", convertedAmount, currencyFrom, currencyTo);
		return convertedAmount;
	}
	

}
