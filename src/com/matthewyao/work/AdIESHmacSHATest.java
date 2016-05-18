package com.matthewyao.work;

import org.apache.commons.codec.binary.Hex;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URI;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by matthewyao on 2016/5/13.
 */
public class AdIESHmacSHATest {

    public static final String KEY = "YOURAPPSECRET";
    public static final String HMACSHA256 = "hmacSHA256";
    public static final String TEST_URL = "GET\n/api_v2/medias/2/reports/ies\napp_key=YOURAPPKEY&date=2016-05-10&pubId=PUB_123456&maxResults=1&signature_method=HmacSHA256&signature_version=1&startIndex=0&timestamp=2016-05-11T08%3A41%3A22Z";

    public static void execute() {
        try {
            byte[] result = encryptHMAC(TEST_URL.getBytes(),KEY);
            String signature = new BigInteger(result).toString(16);
            System.out.println(signature);
            signature = encryptBASE64(signature.getBytes());
            System.out.println(signature);
            signature = URLEncoder.encode(signature, "UTF-8");
            System.out.println(signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
    public static byte[] encryptHMAC(byte[] data, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), HMACSHA256);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        return mac.doFinal(data);
    }


    public static String executeGet(String url){
        BufferedReader in = null;

        String content = null;
        try {
            // 定义HttpClient
            HttpClient client = new DefaultHttpClient();
            // 实例化HTTP方法
            HttpGet request = new HttpGet();
            request.setURI(new URI(url));
            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity()
                    .getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            content = sb.toString();
        } finally {
            if (in != null) {
                try {
                    in.close();// 最后要关闭BufferedReader
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return content;
        }
    }
}
