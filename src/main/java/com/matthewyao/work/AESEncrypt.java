package com.matthewyao.work;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Frank on 10/28/15.
 */
public class AESEncrypt {

    /**
     * 加密函数，返回string密文
     * @param content
     * @param key
     * @return
     */
    public static String getEncryptStr(String content, String key){
        try {
            return parseByte2HexStr(enCrypt(content, key),true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }


    /**
     * 加密函数
     * @param content   加密的内容
     * @param strKey    密钥
     * @return  		返回二进制字符数组
     * @throws Exception
     */
    private static byte[] enCrypt(String content,String strKey) throws Exception{
        KeyGenerator keygen;
        SecretKey desKey;
        Cipher c;
        byte[] cByte;
        String str = content;

        keygen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(strKey.getBytes());
        keygen.init(128, secureRandom);

        desKey = keygen.generateKey();
        c = Cipher.getInstance("AES");

        c.init(Cipher.ENCRYPT_MODE, desKey);

        cByte = c.doFinal(str.getBytes("UTF-8"));

        return cByte;
    }

    /** 解密函数
     * @param src   加密过的二进制字符数组
     * @param strKey  密钥
     * @return
     * @throws Exception
     */
    private static String deCrypt (byte[] src,String strKey) throws Exception{
        KeyGenerator keygen;
        SecretKey desKey;
        Cipher c;
        byte[] cByte;

        keygen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(strKey.getBytes());
        keygen.init(128, secureRandom);

        desKey = keygen.generateKey();
        c = Cipher.getInstance("AES");

        c.init(Cipher.DECRYPT_MODE, desKey);


        cByte = c.doFinal(src);

        return new String(cByte,"UTF-8");
    }


    /**2进制转化成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[],boolean isUpper) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            if (isUpper){
                sb.append(hex.toUpperCase());
            }else {
                sb.append(hex.toLowerCase());
            }
        }
        return sb.toString();
    }


    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
    
    public static String generateKey4NonJava(String strKey) {
        KeyGenerator keygen = null;
        SecureRandom secureRandom = null;
        try {
            keygen = KeyGenerator.getInstance("AES");
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {}
        secureRandom.setSeed(strKey.getBytes());
        keygen.init(128, secureRandom);

        SecretKey desKey = keygen.generateKey();
        byte[] encodedKey = desKey.getEncoded();
        return parseByte2HexStr(encodedKey,false);
    }
}
