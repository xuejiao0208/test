package com.example.demo.controller;

import com.example.demo.entity.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class ManagerController {
    @Resource
    private ManagerService managerService;

    //查询所有员工返回列表页面
    @GetMapping("/managers")
    public String list(Model model){
        Collection<Manager> employees = managerService.getAll();
        employees.toString();

        //放在请求域中
        model.addAttribute("managers",employees);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "manager/list";
    }

    //来到员工添加页面
    @GetMapping("/manager")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        //Collection<Manager> employees = managerService.getAll();
        //model.addAttribute("depts",employees);
        return "manager/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/manager")
    public String addEmp(Manager employee){
        //来到员工列表页面

        System.out.println("保存的员工信息："+employee);
        //保存员工
        managerService.save(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/managers";
    }


    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/manager/{managerId}")
    public String toEditPage(@PathVariable("managerId") String managerId, Model model){
        System.out.println("修改的员工id："+managerId);
        Manager employee = managerService.get(managerId);
        model.addAttribute("manager",employee);

        //回到修改页面(add是一个修改添加二合一的页面);
        return "manager/add";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/manager")
    public String updateEmployee(Manager employee){
        System.out.println("修改的员工数据："+employee.getManagerId());
        if(employee.getManagerId() != null){
            Integer count = managerService.countByUsername(employee.getManagerName());
            if(count == 1){
                managerService.update(employee);
            }

        }else{
            managerService.save(employee);
        }

        return "redirect:/managers";
    }

    //员工删除
    @DeleteMapping("/manager/{managerId}")
    public String deleteEmployee(@PathVariable("managerId") String managerId){
        System.out.println("删除的员工数据："+managerId);
        managerService.delete(managerId);
        return "redirect:/managers";
    }

}

