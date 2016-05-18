package com.matthewyao.work;

import com.sun.jna.platform.win32.OaIdl;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URI;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by matthewyao on 2016/5/13.
 */
public class AdIESHmacSHA {

    public static final String KEY = "e20e5b3b4bce2a8b85ee03f2be346fc9";
    public static final String HMACSHA256 = "hmacSHA256";
    public static final String pattern = "YYYY-MM-dd'T'hh:mm:ss'Z'";
    public static final String charsetName = "UTF-8";
    public static final String TEST_URL = "GET\n/api_v2/medias/2/reports/ies\napp_key=YOURAPPKEY&date=2016-05-10&pubId=PUB_123456&maxResults=1&signature_method=HmacSHA256&signature_version=1&startIndex=0&timestamp=2016-05-11T08%3A41%3A22Z";
    public static final String URL = "GET\n/api_v2/medias/1113/reports/ies\napp_key=d990b49&date=2016-05-16&signature_method=HmacSHA256&signature_version=1&timestamp=";
    public static String FULL_URL = "https://track.admasterapi.com/api_v2/medias/1113/reports/ies?app_key=d990b49&date=2016-05-16&signature_method=HmacSHA256&signature_version=1&timestamp=[TIMESTAMP]&signature=[SIGNATURE]";

    public static void execute() {
        try {
            Mac hmacSha256 = Mac.getInstance(HMACSHA256);
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            String timestamp = sdf.format(new Date());
            String iesUrl = URL + timestamp;
//            System.out.println(iesUrl);

            SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(charsetName), HMACSHA256);
            hmacSha256.init(secretKeySpec);
/*
            byte[] result = hmacSha256.doFinal(URL.getBytes(charsetName));
            byte[] bytes = new Hex().encode(result);
            String signature = new BASE64Encoder().encode(bytes);
            System.out.println(signature);
            signature = URLEncoder.encode(signature, charsetName);
            System.out.println(signature);
            FULL_URL = FULL_URL.replace("[TIMESTAMP]",timestamp);
            FULL_URL = FULL_URL.replace("[SIGNATURE]",signature);
            System.out.println(executeGet(FULL_URL));
*/
            //for test
            byte[] result = hmacSha256.doFinal(TEST_URL.getBytes(charsetName));
            String signature = new BigInteger(result).toString(16);
            System.out.println(signature);
            signature = new BASE64Encoder().encode(signature.getBytes());
            System.out.println(signature);
            signature = URLEncoder.encode(signature, charsetName);
            System.out.println(signature);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
