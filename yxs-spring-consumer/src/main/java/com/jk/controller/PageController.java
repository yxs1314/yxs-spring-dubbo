package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {



    @RequestMapping("toMain")
    public String toMain(){

        return "main";
    }

    @RequestMapping("toUserlistpage")
    public String toUserlistpage(){
        return "userlist";
    }

    @RequestMapping("toRoleListAllEyPage")
    public String toRoleListAllEyPage(){

        return "rolelistpage";
    }
    @RequestMapping("toLogin")
    public String toLogun(){

        return "login";
    }

}
