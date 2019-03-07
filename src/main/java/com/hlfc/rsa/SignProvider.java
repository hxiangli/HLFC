package com.hlfc.rsa;

import java.security.PublicKey;
import java.security.Signature;

import org.apache.commons.codec.binary.Base64;


/**
 * 验证传入的签名
 * @author lfeng@qq.com
 * @since 2017-04-27
 */
public class SignProvider {   
	
	private SignProvider() {   
	}   
	
	/**
	 *  验证传入的签名
	 * @param pubKeyText 公钥
	 * @param plainText 签名前字符串
	 * @param signText 签名后字符
	 * @return
	 */
	public static boolean verify(KeyGenerater keyGenerater, byte[] pubKeyText, String plainText, byte[] signText) {   
		try {   
		  
			// 取公钥匙对象   
			PublicKey pubKey = keyGenerater.restorePublicKey(pubKeyText);   
			// 解密由base64编码的数字签名   
			byte[] signed = Base64.decodeBase64(signText);  
			Signature signatureChecker = Signature.getInstance("MD5withRSA");   
			signatureChecker.initVerify(pubKey);   
			signatureChecker.update(plainText.getBytes());   
			// 验证签名是否正常   
			if (signatureChecker.verify(signed))   
				return true;   
			else   
				return false;   
		} catch (Throwable e) {   
			System.out.println("校验签名失败");   
			e.printStackTrace();   
			return false;   
		}   
	}  
}
