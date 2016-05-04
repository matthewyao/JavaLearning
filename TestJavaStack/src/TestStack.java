/**
 * Created by matthewyao on 2016/4/18.
 */
public class TestStack {
    public static void main(String[] args) {
        String input = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        char[] cs = input.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        char c = cs[0];
        for (int i=1; i<cs.length;){
            if (c == '+'){
                stack.push(cs[i++]);//Auto-boxing
            }
            else if (c == '-'){
                System.out.print(stack.pop());
            }
            c = cs[i++];
        }
    }
}
