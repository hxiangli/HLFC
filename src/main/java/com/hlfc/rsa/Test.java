package com.hlfc.rsa;

import java.net.URLEncoder;

import org.apache.commons.codec.binary.Base64;


/**
 *
 * @author HXL
 * @since 2017-11-28 下午4:40:43
 */
public class Test {

	/**
	 * 生成公私钥对象
	 * @return
	 */
	public static void createPrivate(){
		KeyGenerater keyGenerater = new KeyGenerater(512);
		byte[] privateKey = keyGenerater.getPrivateKey();
		System.out.println("privateKey=" + new String(privateKey));
		byte[] publicKey = keyGenerater.getPublicKey();
		System.out.println("publicKey=" + new String(publicKey));	
		String encode = keyGenerater.RSAEncode(publicKey, "test112@qq.com".getBytes());
		System.out.println("公钥加密的内容："+encode);
		String decode = keyGenerater.RSADecode(privateKey, Base64.decodeBase64(encode.getBytes()));
		System.out.println("私钥解密的内容："+decode);
		byte[] sign =Signaturer.sign(keyGenerater,privateKey, "test112@qq.com");
		System.out.println("sign = " + new String(sign));  
		boolean verify =SignProvider.verify(keyGenerater, publicKey, "test112@qq.com", sign);
		System.out.println("verify = " + verify); 
	}
	
	public static void main(String[] args) {
		createPrivate();
	}
}
