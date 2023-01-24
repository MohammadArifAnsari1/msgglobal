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
public class ConvertedBean {
	private String currencyFrom;
	private String currencyTo;
	private Amount amount;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Amount{
		private String amountFrom;
		private String amountTo;
	}
}
