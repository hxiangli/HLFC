package com.hlfc.exception;

/**
 * 自定义异常
 * @author hxl
 */
public class DefineException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6055510106160734887L;
	
	
	public DefineException(String message){
		super(message);
		
	}
	public DefineException(String message,Throwable throwable){
		super(message,throwable);
		
	}
	
	public DefineException(Throwable throwable){
		super(throwable);
		
	}
}
