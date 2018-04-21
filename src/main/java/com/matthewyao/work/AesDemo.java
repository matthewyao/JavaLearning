package com.matthewyao.work;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

/**
 * Created by matthewyao on 2016/7/29.
 */
public class AesDemo {

    public static void main(String... args){
        try {
            String price = "100";
            String encryptStr = AESEncrypt.getEncryptStr(price,"8f5b054659b4cbb947d07b8facd00f28");
            System.out.println(encryptStr);
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }
}
