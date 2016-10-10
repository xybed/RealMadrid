package com.mumu.realmadrid.controller.home;

import com.mumu.realmadrid.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by 7mu on 2016/7/6.
 */
@Controller
@RequestMapping("/home")
public class BannerController extends BaseController{

    @RequestMapping("/getBanner")
    @ResponseBody
//    @RequestParam("img_file")MultipartFile file
    public String getBanner(HttpServletRequest request){
        InputStream is = null;
        FileOutputStream fos = null;
        String filePath = request.getServletContext().getContextPath();
        System.out.println(filePath);
        System.out.println(getApplicationPath());
        System.out.println(getClass().getResource("/"));
        try {
//            is = request.getInputStream();
//
//            File f = new File(filePath, "111.jpg");
//            fos = new FileOutputStream(f);
//            byte[] b = new byte[1024];
//            int length;
//            while ((length = is.read(b)) != -1){
//                fos.write(b, 0, length);
//            }
//            fos.flush();
            System.out.print("后台成功");
            return "后台成功";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
            return "后台失败";
        } finally {
            try {
                if(is != null)
                    is.close();
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("finally");
        }

    }

    public static void main(String[] args){
        System.out.println(System.getProperty("user.dir"));
    }
}
