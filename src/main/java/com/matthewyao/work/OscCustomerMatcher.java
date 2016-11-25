package com.matthewyao.work;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matthewyao on 2016/11/25.
 */
public class OscCustomerMatcher {
    public static void main(String[] args) throws IOException, SQLException {
        File file = new File("D:/osc_customer.txt");
        File matchFile = new File("D:/match.sql");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));
        String line = "";
        Map<String,Map<String,String>> oscMap = new HashMap<String, Map<String, String>>();
//        Map<String,Integer> customerMatchMap = new HashMap<String, Integer>();
        while ((line = br.readLine()) != null) {
            final List<String> list = Splitter.on("\t").trimResults().omitEmptyStrings().splitToList(line);
            String customerType = list.get(3);
            if (oscMap.containsKey(customerType)){
                oscMap.get(customerType).put(list.get(0),list.get(1));
            }else {
                oscMap.put(customerType, new HashMap<String, String>(){{
                    put(list.get(0),list.get(1));
                }});
            }
        }
        /**同步客户主*/
        Map<String,String> customerMap = oscMap.get("PP_DIRECT_CUSTOMER");
//        ResultSet rs = JdbcTemplate.queryForRowSet("select Id,BrandName,PartyId from BsCustomer where origin = 'CRM'");
        ResultSet rs = JdbcTemplate.queryForRowSet("select Id,BrandName,PartyId,CreateTime from bscustomer where BrandName in ( select BrandName from bscustomer group by BrandName having count(*) > 1 ) and PartyId = 0");
        System.out.println("未匹配客户：");
        while (rs.next()){
            String customerName = rs.getString("BrandName").trim();
            if (customerMap.containsKey(customerName)){
//                System.out.println("update bscustomer set PartyId ="+customerMap.get(customerName)+" where Id ="+rs.getInt("Id"));
            }else {
                System.out.println(customerName);
            }
        }
        /**同步产品*/
        Map<String,String> productMap = oscMap.get("PP_PRODUCT_LINE");
        rs = JdbcTemplate.queryForRowSet("select Id,ProductName,PartyId from BsCustomerProduct where ProductName in ( select ProductName from BsCustomerProduct group by ProductName having count(*) > 1 ) and PartyId = 0");
        System.out.println("未匹配产品线：");
        while (rs.next()){
            String productName = rs.getString("ProductName").trim();
            if (productMap.containsKey(productName)){
//                System.out.println("update BsCustomerProduct set PartyId ="+productMap.get(productName)+" where Id ="+rs.getInt("Id"));
            }else {
                System.out.println(productName);
            }
        }
        /**同步代理公司*/
        Map<String,String> proxyMap = oscMap.get("PP_AGENT");
        rs = JdbcTemplate.queryForRowSet("select Id,Title,PartyId from BsProxyCompany where Title in ( select Title from BsProxyCompany group by Title having count(*) > 1 ) and PartyId = 0");
        System.out.println("未匹配代理公司：");
        while (rs.next()){
            String proxyName = rs.getString("Title").trim();
            if (proxyMap.containsKey(proxyName)){
//                System.out.println("update BsProxyCompany set PartyId ="+proxyMap.get(proxyName)+" where Id ="+rs.getInt("Id"));
            }else {
                System.out.println(proxyName);
            }
        }
        /**同步框架*/
        Map<String,String> frameMap = oscMap.get("PP_FRAMEWORK");
        frameMap.putAll(oscMap.get("PP_SECONDARY_AGENT"));
        rs = JdbcTemplate.queryForRowSet("select Id,Title,PartyId from BsFrame where Title in ( select Title from BsFrame group by Title having count(*) > 1 ) and PartyId = 0");
        System.out.println("未匹配框架：");
        while (rs.next()){
            String frameName = rs.getString("Title").trim();
            if (frameMap.containsKey(frameName)){
//                System.out.println("update BsFrame set PartyId ="+frameMap.get(frameName)+" where Id ="+rs.getInt("Id"));
            }else {
                System.out.println(frameName);
            }
        }
//        /**同步二级代理*/
//        Map<String,String> secondFrameMap = oscMap.get("PP_SECONDARY_AGENT");
//        rs = JdbcTemplate.queryForRowSet("select Id,Title,PartyId from BsFrame where Title in ( select Title from BsFrame group by Title having count(*) > 1 ) and PartyId = 0");
//        System.out.println("未匹配二级代理：");
//        while (rs.next()){
//            String secondFrameName = rs.getString("Title").trim();
//            if (secondFrameMap.containsKey(secondFrameName)){
////                System.out.println("update BsFrame set PartyId ="+secondFrameMap.get(secondFrameName)+" where Id ="+rs.getInt("Id"));
//            }else {
//                System.out.println(secondFrameName);
//            }
//        }
    }
}
