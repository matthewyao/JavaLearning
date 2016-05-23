package com.matthewyao.work;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by robinzhou on 2016/5/18.
 */
public class AdIESHmacSHATest {

    public static final String KEY = "e20e5b3b4bce2a8b85ee03f2be346fc9";
    public static final String PATTERN = "yyyy-MM-dd'T'hh:mm:ss'Z'";
//    public static final String URL = "GET\n/api_v2/medias/1113/reports/ies\napp_key=d990b49&date=2016-05-18&signature_method=HmacSHA256&signature_version=1&timestamp=";
//    public static String FULL_URL = "https://track.admasterapi.com/api_v2/medias/1113/reports/ies?app_key=d990b49&date=2016-05-18&signature_method=HmacSHA256&signature_version=1&timestamp=[TIMESTAMP]&signature=[SIGNATURE]";
    public static final String URL = "GET\n/api_v2/medias/1113/reports/ies\napp_key=d990b49&date=2016-05-19&signature_method=HmacSHA256&signature_version=1&timestamp=";
    public static String FULL_URL = "https://track.admasterapi.com/api_v2/medias/1113/reports/ies?app_key=d990b49&date=2016-05-19&signature_method=HmacSHA256&signature_version=1&timestamp=[TIMESTAMP]&signature=[SIGNATURE]";

    public static void execute(){
        String signature = null;
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String timestamp = sdf.format(new Date());
        try {
            timestamp = URLEncoder.encode(timestamp, "UTF-8");
            String iesUrl = URL + timestamp;
            signature = hmacSHA256(KEY, iesUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FULL_URL = FULL_URL.replace("[TIMESTAMP]",timestamp);
        FULL_URL = FULL_URL.replace("[SIGNATURE]",signature);
        System.out.println("result:"+executeGet(FULL_URL));
    }

    public static String hmacSHA256( String key, String message) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        String signature = Base64.encodeBase64String(sha256_HMAC.doFinal(message.getBytes("UTF-8")));
        signature = URLEncoder.encode(signature, "UTF-8");
        System.out.println(signature);
        return signature;
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
