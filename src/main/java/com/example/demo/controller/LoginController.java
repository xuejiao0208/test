package com.example.demo.controller;

import com.example.demo.entity.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
//@RequestMapping("/user")
public class LoginController {

    @Resource
    private ManagerService managerService;

//    @DeleteMapping
//    @PutMapping
//    @GetMapping


    @RequestMapping({"/","/index.html"})
    public String index(){
        return "login";//springmvc  逻辑视图 web-inf/login.jsp
    }


    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    //@PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) ){
            Manager manager = managerService.getManagerByUsername(username);
            if(manager  != null){
                if(manager.getManagerPwd().equals(password)){
                    //登陆成功，防止表单重复提交，可以重定向到主页
                    session.setAttribute("loginUser",username);
                    return "dashboard";
                }else{
                    //登陆失败

                    map.put("msg","密码错误");
                    return  "login";
                }
            }else{
                //登陆失败

                map.put("msg","用户名不存在");
                return  "login";
            }


        }else{
            //登陆失败

            map.put("msg","用户名或密码为空");
            return  "login";
        }

    }

}
