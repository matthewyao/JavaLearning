package com.matthewyao.work;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matthewyao on 2016/5/9.
 */
public class AdIesAreaMatch {

    private Map<String,String> adAreaMap = new HashMap<String, String>();
    private Map<String,String> pptvAreaMap = new HashMap<String, String>();

    public void matchAreaName(){
        File adCityFile = new File("H:\\Workspace\\AdMasterIES\\new_city.csv");
        File adProvinceFile = new File("H:\\Workspace\\AdMasterIES\\new_province.csv");
        File adForeignFile = new File("H:\\Workspace\\AdMasterIES\\new_foreign.csv");
        List<File> adFileList = new ArrayList<File>();
        adFileList.add(adCityFile);
        adFileList.add(adProvinceFile);
        adFileList.add(adForeignFile);

        File pptvAreaFile = new File("H:\\Workspace\\AdMasterIES\\pptv_data.csv");

        try {
            //合并AdMaster的地域数据
            for (File file : adFileList){
                BufferedReader adReader = new BufferedReader(new FileReader(file));
                adReader.readLine();//跳过首行
                mergeAdAreaToMap(adReader);
            }
            //合并PPTV的地域数据
            BufferedReader pptvReader = new BufferedReader(new FileReader(pptvAreaFile));
            pptvAreaToMap(pptvReader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //比较数据差异
        compareAreaData();
    }

    private void mergeAdAreaToMap(BufferedReader br){
        String line;
        try {
            while ((line = br.readLine()) != null){
                String id = line.split(",")[0];
                String name = line.split(",")[1];
                name = name.replaceAll("\"","");
                adAreaMap.put(id,name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pptvAreaToMap(BufferedReader br){
        String line;
        try {
            while ((line = br.readLine()) != null){
                String id = line.split("\t")[0];
                String name = line.split("\t")[1];
                pptvAreaMap.put(id,name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void compareAreaData(){
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(new File("H:\\Workspace\\AdMasterIES\\ad_data.sql")));
            for (Map.Entry<String, String> pptvEntry : pptvAreaMap.entrySet()) {
                boolean isMatch = false;
                for (Map.Entry<String, String> adEntry : adAreaMap.entrySet()) {
                    String sql = "INSERT INTO `pplive_ad`.`ad_data_area_ads2admaster` (`adsId`, `adsName`, `admasterId`, `admasterName`) VALUES (:adsId, ':adsName', :admasterId, ':admasterName');";
                    //AdMaster的地域名称包含PPTV名称
                    if (adEntry.getValue().contains(pptvEntry.getValue()) || pptvEntry.getValue().contains(adEntry.getValue())) {
                        sql = sql.replace(":adsId", pptvEntry.getKey());
                        sql = sql.replace(":adsName", pptvEntry.getValue());
                        sql = sql.replace(":admasterId", adEntry.getKey());
                        sql = sql.replace(":admasterName", adEntry.getValue());
                        bw.write(sql);
                        bw.newLine();
                        //                    System.out.println("Yes:"+pptvEntry.getKey()+" "+pptvEntry.getValue()+" "+adEntry.getKey()+" "+adEntry.getValue());
                        //                    isMatch = true;
                    }
                }
            }
            bw.flush();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
//            if (!isMatch){
//                System.out.println("Not:"+pptvEntry.getKey()+" "+pptvEntry.getValue());
//            }
    }

//        for (Map.Entry<String, String> adEntry : adAreaMap.entrySet()) {
//            boolean isMatch = false;
//            for (Map.Entry<String, String> pptvEntry : pptvAreaMap.entrySet()) {
//                //AdMaster的地域名称包含PPTV名称
//                if (adEntry.getValue().contains(pptvEntry.getValue()) || pptvEntry.getValue().contains(adEntry.getValue())){
//                    isMatch = true;
//                }
//            }
//            if (!isMatch){
//                System.out.println("Not:"+adEntry.getKey()+" "+adEntry.getValue());
//            }
//        }
}

