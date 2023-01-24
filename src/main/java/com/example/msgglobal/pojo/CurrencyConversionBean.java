package com.example.msgglobal.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mohammad Arif Ansari
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CurrencyConversionBean {
	
	private String code;
	private String alphaCode;
	private String name;
	private String rate;
	private String date;
	private String inverseRate;
	
}
