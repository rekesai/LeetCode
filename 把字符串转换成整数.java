public class 把字符串转换成整数 {

    
    public int StrToInt1(String str) {
        if (str == "" || str.length() == 0) {
            return 0;
        }
        int flg = 1;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum += (str.charAt(i)-'0')*Math.pow(10, str.length()-i-1);
            }
            else {
                if (i == 0) {
                    if (str.charAt(i) == '+') {
                        continue;
                    }
                    else if (str.charAt(i) == '-') {
                        flg = -1;
                        continue;
                    }
                    else {
                        return 0;
                    }
                }
                return 0;
            }
        }
        return sum*flg;
    }
}
