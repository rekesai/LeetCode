public class 替换空格 {
    // 替换空格用StringBuilder来拼接，最后toString()
    public String replaceSpace (String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }
            else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
