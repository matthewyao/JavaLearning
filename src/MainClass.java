import com.matthewyao.sikuli.JavaSikuliDemo;
import com.matthewyao.sikuli.TestOCR;
import com.matthewyao.work.AdIESHmacSHATest;

/**
 * Created by matthewyao on 2016/5/9.
 */
public class MainClass {
    public static void main(String[] args) {
//        new AdIesAreaMatch().matchAreaName();//测试地域名称匹配
//        new VerifyCodeUtil().execute();//测试验证码
//        new TestWebDriver().execute();//测试webDriver
//        new AdIESHmacSHA().execute();//Admaster IES功能
        new AdIESHmacSHATest().execute();
//        new JavaSikuliDemo().execute();//测试Sikuli拍牌
//        new TestOCR().execute();//测试OCR功能
    }
}
