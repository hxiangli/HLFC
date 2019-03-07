package com.hlfc.rsa;

import java.security.PrivateKey;
import java.security.Signature;

import org.apache.commons.codec.binary.Base64;


/**
 * 数字签名
 * @author lfeng@qq.com
 * @since 2017-04-27
 */
public class Signaturer {   
	/**	
	 * 获取签名后的字节
	 * @param priKeyText 私钥
	 * @param plainText 需签名的内容
	 * @return 签名后字节
	 */
	public static byte[] sign(KeyGenerater keyGenerater, byte[] priKeyText, String plainText) {   
		try {   
			PrivateKey prikey = keyGenerater.restorePrivateKey(priKeyText); 
			// 用私钥对信息生成数字签名   
			Signature signet = java.security.Signature.getInstance("MD5withRSA");   
			signet.initSign(prikey);   
			signet.update(plainText.getBytes());   
			byte[] signed = Base64.encodeBase64(signet.sign()); 
			return signed;   
		} catch (java.lang.Exception e) {   
			System.out.println("签名失败");   
			e.printStackTrace();   
		}   
		return null;   
	}  
	
}
