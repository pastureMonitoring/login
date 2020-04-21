package com.ndd.pasturelogin.controller;

import com.ndd.pasturelogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ndd
 * @version 2.x
 * @date 2020/4/21 15:08
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/loginform")
    public String loginform(@RequestParam("username")String userAccount,@RequestParam("password")String password){
        System.out.println(userAccount+","+password);
        boolean b = loginService.loginJudge(userAccount, password);
        if(b){
            return "redirect:success";
        }else return "redirect:login";
    }
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
