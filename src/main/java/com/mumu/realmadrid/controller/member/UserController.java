package com.mumu.realmadrid.controller.member;

import com.mumu.realmadrid.controller.BaseController;
import com.mumu.realmadrid.model.BaseModel;
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
    public void register(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        generateToken(session, username);
    }

    @RequestMapping("/login")
    @ResponseBody void login(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("token"));
    }
}
