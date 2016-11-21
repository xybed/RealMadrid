package lib.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiqi on 2016/11/17.
 */
public class DateUtil {

    public static String getNowDate(){
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        return df.format(new Date());
    }
}
