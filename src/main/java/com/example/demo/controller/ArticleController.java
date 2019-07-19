package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.entity.Nav;
import com.example.demo.service.ArticleService;
import com.example.demo.service.NavService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private NavService navService;
    //查询所有文章返回列表页面
    @GetMapping("/articles")
    public String list(Model model){
        Collection<Article> employees = articleService.getAllA();
        //放在请求域中
        model.addAttribute("articles",employees);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "article/list";
    }

    //添加文章页面
    @GetMapping("/article")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的文章，在页面显示
        Collection<Nav> employees = navService.getAll();
        model.addAttribute("navs",employees);
        return "article/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/article")
    public String addNav(Article nav){
        //来到员工列表页面

        System.out.println("保存的员工信息："+nav);
        //保存员工
        articleService.saveA(nav);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/articles";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/article/{articleId}")
    public String toEditPage(@PathVariable("articleId") String articleId, Model model){
        System.out.println("保存的员工信息："+articleId);
        Article employee = articleService.getA(articleId);
        model.addAttribute("article",employee);

        //页面要显示所有的部门列表
        Collection<Nav> departments = navService.getAll();
        model.addAttribute("navs",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "article/add";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/article")
    public String updateEmployee(Article employee){
        System.out.println("修改的员工数据："+employee.getArticleId());
        if(null != employee.getArticleId()){
            articleService.updateA(employee);
        }else{
            articleService.saveA(employee);
        }

        return "redirect:/article";
    }


    //员工删除
    @DeleteMapping("/article/{articleId}")
    public String deleteNav(@PathVariable("articleId") String articleId){
        System.out.println("删除的员工数据："+articleId);
        articleService.delete(articleId);
        return "redirect:/articles";
    }


}
