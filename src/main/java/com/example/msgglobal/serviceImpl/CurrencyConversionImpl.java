package com.example.msgglobal.serviceImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.example.msgglobal.service.CurrencyConversionIF;
import com.google.gson.Gson;

/**
 * @author Mohammad Arif Ansari
 *
 */
@Service
public class CurrencyConversionImpl implements CurrencyConversionIF{
	
	/**
	 *	Takes 3 input parameter 
	 *	@param currencyFrom
	 *  @param currencyTo
	 *  @param quantity
	 *  @return Map<String, String> -- converted amount in asked currency
	 *  
	 */
	@SuppressWarnings("removal")
	@Override
	public Map<String, String> currencyConversionService(String currencyFrom, String currencyTo, String quantity)
			throws JSONException, MalformedURLException, IOException {

		JSONObject json = new JSONObject(IOUtils.toString(new URL("http://www.floatrates.com/daily/eur.json"), Charset.forName("UTF-8")));
		
		Object object = json.get(currencyTo.toLowerCase());
		Map<String, String> convertedMap = new HashMap<>();
		
		String jsonInString = new Gson().toJson(object);
		JSONObject mJSONObject = new JSONObject(jsonInString);
		
		convertedMap.put("Code", mJSONObject.get("code").toString());
		convertedMap.put("Name", mJSONObject.get("name").toString());
		convertedMap.put("CurrencyFrom", currencyFrom);
		convertedMap.put("CurrencyTo", currencyTo);
		
		Long amountTo = new Long(quantity) * new Long(mJSONObject.get("rate").toString());
		
		convertedMap.put("ConvertedAmount", amountTo.toString());
		
		return convertedMap;
	}
}
