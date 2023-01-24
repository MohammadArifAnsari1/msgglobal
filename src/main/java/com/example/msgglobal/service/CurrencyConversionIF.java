package com.example.msgglobal.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.json.JSONException;

public interface CurrencyConversionIF {
	
	public Map<String, String> currencyConversionService(String currencyFrom, String currencyTo, String quantity) throws JSONException, MalformedURLException, IOException;
	
}
