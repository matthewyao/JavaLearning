package com.matthewyao.sikuli.service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

import com.matthewyao.sikuli.util.Hex;

/**
 * Created by matthewyao on 2016/1/22.
 */
public class TestAes {
    private static String deCrypt(byte[] src,String strKey) throws Exception{
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(strKey.getBytes());

        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(128,secureRandom);

        Cipher c = Cipher.getInstance("AES");
        SecretKey desKey = keygen.generateKey();
        c.init(Cipher.DECRYPT_MODE, desKey);
        byte[] cByte = c.doFinal(src);

        return new String(cByte,"UTF-8");
    }

    /**
     * 1.������е����ֶ��ǰ������ʾ
     * 2.���������� = ���� = ���� ; ����������λ���䣨��0��1��������λ��λȡ����ĩλ��1
     * 3.��8�ֽ�byte -121��ԭ�룺11111001�����룺10000110�����룺10000111
     * 4.10000111 & 0xFF => 10000111 => 87
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String bStr = Integer.toBinaryString(buf[i]);
            System.out.println(buf[i]+" : "+bStr);
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    private static String enCrypt(byte[] src,String strKey) throws Exception{
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(strKey.getBytes());

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128,secureRandom);

        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bResult = cipher.doFinal(src);
        String result = parseByte2HexStr(bResult);
        System.out.println("result:"+result);
        return result;
    }

    /**
    * 1.First we use 32 bit key 83eef105eba240eb751bc076330dc58b to encode 300 to 87F344C177C5140911A91DAD58E12A87
    * 2.The key is 32 bit used AES crypt whose result is 32 bit as well
    * 3.We got a result of  87F344C177C5140911A91DAD58E12A87 and a key of 83eef105eba240eb751bc076330dc58b
    * 4.We decrypt 87F344C177C5140911A91DAD58E12A87 and get 300 as result
    */
    public static void main(String[] args) {
        try{
            /**
             * 1."300".getBytes() => "300" => '3','0','0' => Get ASCII Code => 51,48,48
             * */
            String enCrpty = enCrypt("300".getBytes("UTF-8"),"83eef105eba240eb751bc076330dc58b") ;
            System.out.println("300 encrypt to:"+enCrpty);
            String value = deCrypt(Hex. decodeHex("87F344C177C5140911A91DAD58E12A87".toCharArray()) ,
                    "83eef105eba240eb751bc076330dc58b");
            System.out.println(value);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
