import java.util.Scanner;

public class 字符串中找出连续最长的数字串 {
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/bd891093881d4ddf9e56e7cc8416562d
     * 来源：牛客网
     *
     * 读入一个字符串str，输出字符串str中的连续最长的数字串
     *
     * 输入描述:
     * 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
     *
     * 输出描述:
     * 在一行内输出str中里连续最长的数字串。
     * 示例1
     * 输入
     * abcd12345ed125ss123456789
     * 输出
     * 123456789
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String s = "";
            String tmp = "";
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    s = s+str.charAt(i);
                }
                else{
                    tmp = tmp.length()>s.length() ? tmp:s;
                    s = "";
                }
            }
            tmp = tmp.length()>s.length() ? tmp:s;
            System.out.println(tmp);
        }
    }
}
