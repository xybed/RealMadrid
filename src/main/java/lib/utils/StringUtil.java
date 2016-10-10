package lib.utils;

/**
 * Created by 7mu on 2016/5/24.
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param s 字符串
     * @return true代表空，false代表不为空
     */
    public static boolean isEmpty(String s){
        if (null == s)
            return true;
        if (s.length() == 0)
            return true;
        return s.trim().length() == 0;
    }

    /**
     * 替换\n
     *
     * @param str
     * @return
     */
    public static String replaceWrap(String str) {
        if(!isEmpty(str)){
            str = str.replaceAll("\\r\\n", "\n").replaceAll("\\\\n", "\n").replaceAll("\\r\\r","\n");
        }
        return str;
    }
}
