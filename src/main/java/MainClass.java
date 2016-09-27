import com.matthewyao.designpattern.ProxyPattern;
import com.matthewyao.leetcode.*;
import com.matthewyao.test.TestMultiThread;

/**
 * Created by matthewyao on 2016/5/9.
 */
public class MainClass {
    public static void main(String[] args) {
//        new AdIesAreaMatch().matchAreaName();//测试地域名称匹配
//        new VerifyCodeUtil().execute();//测试验证码
//        new TestWebDriver().execute();//测试webDriver
//        new AdIESHmacSHA().execute();//Admaster IES功能
//        new AdIESHmacSHATest().execute();
//        new JavaSikuliDemo().execute();//测试Sikuli拍牌
//        new TestOCR().execute();//测试OCR功能
//        try {
//            TimeTest.execute();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        new ReverseString().reverseString("hello");
//        new NimGames().canWinNim(4);
//        System.out.println(new SumofTwoIntegers().getSum(34,-125));
//        System.out.println(new FindTheDifference().findTheDifference("abcdeface","baedgfceca"));
//        System.out.println(new SingleNumber().singleNumber(new int[]{1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1}));
//        System.out.println(new AddDigits().addDigits(123456));
//        System.out.println(new MaximumDepthofBinaryTree().maxDepth());
//        ProxyPattern.execute();
//        TestMultiThread.execute("yk","123");
//        new CountingBits().countBits(5);
        new InputArrayIsSorted().twoSum(new int[]{1,2,3,4,4,9,56,90},8);
    }
}
