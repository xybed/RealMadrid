package com.mumu.realmadrid.controller.member;

import com.mumu.realmadrid.common.Constants;
import com.mumu.realmadrid.controller.BaseController;
import com.mumu.realmadrid.exception.RegisteredException;
import com.mumu.realmadrid.model.BaseModel;
import com.mumu.realmadrid.model.member.UserModel;
import com.mumu.realmadrid.pojo.member.User;
import com.mumu.realmadrid.service.member.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7mu on 2016/6/27.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public BaseModel toIndex(HttpServletRequest request){
        String userId = request.getParameter("id");
        String token = request.getParameter("token");
        System.out.println(token);
        String platform = request.getParameter("platform");
        System.out.println(platform);
        String ver = request.getParameter("ver");
        System.out.println(ver);
        User user = userService.getUserById(userId);
        List<User> list = new ArrayList<User>();
        list.add(user);
        User user2 = new User();
        user2.setUsername("qiqi");
        user2.setPassword("jiajia");
        list.add(user2);
        BaseModel baseModel = new BaseModel();
        baseModel.setResultType(1);
        baseModel.setResultCode(-99);
        baseModel.setDetail("成功");
        baseModel.setData(user);
        return baseModel;
    }

    @RequestMapping("/register")
    @ResponseBody
    public BaseModel register(HttpServletRequest request){
        //验证签名sign，保证请求的安全性
        String queryString = request.getQueryString();
        String sign = request.getParameter("sign");
        BaseModel baseModel = new BaseModel();
        if(!validateSign(queryString, sign)){
            baseModel.setResultType(-1);
            baseModel.setResultCode(-1);
            return baseModel;
        }
        //拿到请求参数
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verifyCode = request.getParameter("verifyCode");
        //生成token
        String token = generateToken(session, username);
        try {
            UserModel userModel = userService.register(username, password, verifyCode);
            //注册成功，设置token，加上基地址，把需要的用户信息返回给前端
            userModel.setToken(token);
            userModel.setAvatar(Constants.BASE_URL + userModel.getAvatar());
            baseModel.setData(userModel);
        } catch (RegisteredException e) {
            //可能注册过，返回错误信息
            e.printStackTrace();
            baseModel.setDetail(e.getMessage());
        }
        return baseModel;
    }

    @RequestMapping("/login")
    @ResponseBody void login(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("token"));
    }
}
