package com.matthewyao.practice.spider;

/**
 * Created by matthewyao on 2016/1/22.
 */
import java.io.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.*;

public class DownTool {
    /**
     * ���� URL ����ҳ����������Ҫ�������ҳ���ļ�����ȥ�� URL �еķ��ļ����ַ�
     */
    private String getFileNameByUrl(String url, String contentType) {
        // �Ƴ� "http://" ���߸��ַ�
        url = url.substring(7);
        // ȷ��ץȡ����ҳ��Ϊ text/html ����
        if (contentType.indexOf("html") != -1) {
            // �����е�url�е��������ת�����»���
            url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
        } else {
            url = url.replaceAll("[\\?/:*|<>\"]", "_") + "."
                    + contentType.substring(contentType.lastIndexOf("/") + 1);
        }
        return url;
    }
    /**
     * ������ҳ�ֽ����鵽�����ļ���filePath ΪҪ������ļ�����Ե�ַ
     */
    private void saveToLocal(byte[] data, String filePath) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(
                    new File(filePath)));
            for (int i = 0; i < data.length; i++)
                out.write(data[i]);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // ���� URL ָ�����ҳ
    public String downloadFile(String url) {
        String filePath = null;
        // 1.���� HttpClinet�������ò���
        HttpClient httpClient = new HttpClient();
        // ���� HTTP���ӳ�ʱ 5s
        httpClient.getHttpConnectionManager().getParams()
                .setConnectionTimeout(5000);
        // 2.���� GetMethod�������ò���
        GetMethod getMethod = new GetMethod(url);
        // ���� get����ʱ 5s
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        // �����������Դ���
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler());
        // 3.ִ��GET����
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            // �жϷ��ʵ�״̬��
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: "
                        + getMethod.getStatusLine());
                filePath = null;
            }
            // 4.���� HTTP ��Ӧ����
            byte[] responseBody = getMethod.getResponseBody();// ��ȡΪ�ֽ�����
            // ������ҳ url ���ɱ���ʱ���ļ���
            filePath = "temp\\"
                    + getFileNameByUrl(url,
                    getMethod.getResponseHeader("Content-Type")
                            .getValue());
            File file = new File(filePath);
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdir();
            }
            saveToLocal(responseBody, filePath);
        } catch (HttpException e) {
            // �����������쳣��������Э�鲻�Ի��߷��ص�����������
            System.out.println("�������http��ַ�Ƿ���ȷ");
            e.printStackTrace();
        } catch (IOException e) {
            // ���������쳣
            e.printStackTrace();
        } finally {
            // �ͷ�����
            getMethod.releaseConnection();
        }
        return filePath;
    }
}
