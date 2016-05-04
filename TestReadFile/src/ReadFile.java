import java.io.*;

/**
 * Created by matthewyao on 2016/4/18.
 */
public class ReadFile {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/mz_area_data.txt");
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        InputStream inputStream = new FileInputStream(file);
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}
