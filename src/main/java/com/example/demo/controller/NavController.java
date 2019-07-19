package com.example.demo.controller;

import com.example.demo.entity.Manager;
import com.example.demo.entity.Nav;
import com.example.demo.service.NavService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class NavController {
    @Resource
    private NavService navService;

    //查询所有员工返回列表页面
    @GetMapping("/navs")
    public String list(Model model){
        Collection<Nav> navs = navService.getAll();

        //放在请求域中
        model.addAttribute("navs",navs);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "nav/list";
    }

    //来到员工添加页面
    @GetMapping("/nav")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        //Collection<Manager> employees = managerService.getAll();
        //model.addAttribute("depts",employees);
        return "nav/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/nav")
    public String addNav(Nav nav){
        //来到员工列表页面

        System.out.println("保存的员工信息："+nav);
        //保存员工
        navService.save(nav);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/navs";
    }


    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/nav/{navId}")
    public String toEditPage(@PathVariable("navId") String navId, Model model){
        System.out.println("修改的员工id："+navId);
        Nav nav = navService.getNavByNavid(navId);
        model.addAttribute("nav",nav);

        //回到修改页面(add是一个修改添加二合一的页面);
        return "nav/add";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/nav")
    public String updateNav(Nav nav){
        System.out.println("修改的员工数据："+nav.getNavId());
        if(nav.getNavId() != null){
            Integer count = navService.countByNavid(nav.getNavId());
            if(count == 1){
                navService.update(nav);
            }

        }else{
            navService.save(nav);
        }

        return "redirect:/navs";
    }

    //员工删除
    @DeleteMapping("/nav/{navId}")
    public String deleteNav(@PathVariable("navId") String navId){
        System.out.println("删除的员工数据："+navId);
        navService.delete(navId);
        return "redirect:/navs";
    }

}
