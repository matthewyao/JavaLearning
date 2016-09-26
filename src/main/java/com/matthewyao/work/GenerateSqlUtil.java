package com.matthewyao.work;

import java.io.*;

/**
 * Created by matthewyao on 2016/8/24.
 */
public class GenerateSqlUtil {

    private static String SQL = "INSERT INTO sys_staff(ext_id,chinese_name,display_name,department_id,email,export_user_id,employee_state) "+
            "VALUES(:extId,':chineseName',':displayName',:depId,':email',:userId,':empState');\n";

    public static void execute() {
        File file = new File("E:\\桌面文件\\文件管理系统\\员工信息.csv");
        File outFile = new File("E:\\桌面文件\\文件管理系统\\staff.sql");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(outFile);
            BufferedWriter bw = new BufferedWriter(fw);

            String line = null;
            while ((line = br.readLine()) != null){
                int index = 0;
                String[] strs = line.split(",");

                String newSql = SQL.replace(":extId",strs[index++])
                    .replace(":chineseName",strs[index++])
                    .replace(":displayName",strs[index++])
                    .replace(":depId",strs[index++])
                    .replace(":email",strs[index++])
                    .replace(":userId",strs[index++])
                    .replace(":empState",strs[index++]);
                bw.write(newSql);
            }

            bw.flush();
            fr.close();
            br.close();
            fw.close();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
