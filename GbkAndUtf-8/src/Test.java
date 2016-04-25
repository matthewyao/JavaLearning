import java.io.*;
import java.util.Map;

/**
 * Created by matthewyao on 2016/4/25.
 */
public class Test {
    /***/
    public static void main(String[] args) throws IOException {
        System.out.println("测试一下");
        System.out.println(System.getProperty("file.encoding"));
        //Windows下默认文件都是使用GBK编码，Intellij idea默认会使用UTF-8的编码方式读取文件，导致乱码
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/mz_area_data.txt"),"utf-8"));
        for (int i = 0; i<3; i++){
            System.out.println(br.readLine());
        }
        //显示所有操作系统环境变量
        for (Map.Entry entry : System.getenv().entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        for (String s : System.getenv().values()){
            System.out.println(s);
        }
    }
}
