package com.hlfc.rsa;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;


/**
 * RSA秘钥生成器
 * @author lfeng
 * @since 2017-04-27
 */
public class KeyGenerater {   
	
	public static final String KEY_ALGORITHM = "RSA";
	/** 默认是RSA/NONE/PKCS1Padding */
	public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";

	
	private KeyPairGenerator keyPairGenerator ;
	private static KeyPair keyPair;
	
	/** 初始化秘钥生成器,参数为8的倍数，512-65536之间默认是1024*/
	public KeyGenerater(int keySize){
		try {
			keyPairGenerator  = KeyPairGenerator .getInstance(KEY_ALGORITHM);
			keyPairGenerator .initialize(keySize);
			keyPair = keyPairGenerator .generateKeyPair(); 
		} catch (NoSuchAlgorithmException e) {
			System.out.println("生成密钥对失败");  
			e.printStackTrace();
		}   
		   
	}
	
	/**
	 * 获取私钥
	 * @return 
	 */
	public byte[] getPrivateKey() {  
		
		PrivateKey privateKey = keyPair.getPrivate();   			
		return Base64.encodeBase64(privateKey.getEncoded());
	} 
	
	/**
	 * 获取公钥
	 * @return 
	 */
	public byte[] getPublicKey() {  
		
		PublicKey publicKey = keyPair.getPublic();   			
		return Base64.encodeBase64(publicKey.getEncoded());
	} 
	
	/**
     * 还原公钥，X509EncodedKeySpec 用于构建公钥的规范
     * 
     * @param keyBytes
     * @return
     */
    public PublicKey restorePublicKey(byte[] pubKeyText) {
       
		try {
			// 解密由base64编码的公钥,并构造X509EncodedKeySpec对象   
			X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(pubKeyText));   
			// RSA对称加密算法   
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);   
			// 取公钥匙对象   
			PublicKey publicKey = keyFactory.generatePublic(bobPubKeySpec);   
            return publicKey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
        return null;
    }

    /**
     * 还原私钥，PKCS8EncodedKeySpec 用于构建私钥的规范
     * 
     * @param keyBytes
     * @return
     */
    public PrivateKey restorePrivateKey(byte[] priKeyText) {

        try {
        	// 解密由base64编码的公钥,并构造PKCS8EncodedKeySpec对象   
        	PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(priKeyText));   
        	// RSA对称加密算法   
        	KeyFactory keyf = KeyFactory.getInstance(KEY_ALGORITHM);   
        	// 取公钥匙对象   
        	PrivateKey privateKey = keyf.generatePrivate(priPKCS8); 
            return privateKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
        return null;
    }
	
	/**
	 * 公钥加密
	 * @param key 公钥
	 * @param plainText 需加密字符
	 * @return 加密后字符
	 */
	public  String RSAEncode(byte[] pubKey, byte[] plainText) {
		
			try {
				//还原公钥
				PublicKey publicKey = restorePublicKey(pubKey);
				Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
				return new String(Base64.encodeBase64(cipher.doFinal(plainText)));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}		
		return null;
	
	} 
	
	 /**
     * 私钥解密
     * 
     * @param key 私钥
     * @param encodedText 需解密的字符
     * @return 解密后字符
     */
    public String RSADecode(byte[] PriKey, byte[] encodedText) {

		try {
			//还原私钥
			PrivateKey privateKey = restorePrivateKey(PriKey);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return new String(cipher.doFinal(encodedText));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {		
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}       
        return null;
    }
	  
//	public static void main(String[] args) {
//		KeyGenerater keyGenerater = new KeyGenerater(512);
//		byte[] privateKey = keyGenerater.getPrivateKey();
//		System.out.println("privateKey=" + new String(privateKey));
//		byte[] publicKey = keyGenerater.getPublicKey();
//		System.out.println("publicKey=" + new String(publicKey));	
//		String encode = keyGenerater.RSAEncode(publicKey, "test112@qq.com".getBytes());
//		System.out.println(encode);
//		String decode = keyGenerater.RSADecode(privateKey, Base64Utils.decode(encode.getBytes()));
//		System.out.println(decode);
//		byte[] sign =Signaturer.sign(keyGenerater,privateKey, "test112@qq.com");
//		System.out.println("sign = " + new String(sign));  
//		boolean verify =SignProvider.verify(keyGenerater, publicKey, "test112@qq.com", sign);
//		System.out.println("verify = " + verify); 
//	}
}
