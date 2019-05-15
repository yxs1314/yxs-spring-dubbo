package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.*;
import com.jk.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;


    @RequestMapping("query")
    @ResponseBody
    public List<User> query(){
        List<User> list = userService.queryUserList();
        return list;
    }

    @RequestMapping("findNavTreeCommon")
    @ResponseBody
    public  List<NavBean> findNavTreeCommon(){
        return userService.findNavTreeCommon();
    }

    @RequestMapping("findUser")
    @ResponseBody
    public HashMap<String,Object> findUser(Integer page, Integer rows){
        System.out.println(111111111);
        System.out.println(22222);

        return userService.findUser(page,rows);


    }
    @RequestMapping("deleteou")
    @ResponseBody
    public boolean deleteou(Integer[] ids){
        try {
            userService.deleteou(ids);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("authorSelect")
    @ResponseBody
    public List<DeptBean> authorSelect(){
        return userService.authorSelect();
    }

    @RequestMapping("roleSelect")
    @ResponseBody
    public List<RoleBean> roleSelect(){
        return userService.roleSelect();
    }

    @RequestMapping("addUser")
    @ResponseBody
    public boolean addUser(UserBean userBean){
        try {
            userService.addUser(userBean);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("findRole")
    @ResponseBody
    public HashMap<String,Object> findRole(Integer page, Integer rows){
        return userService.findRole(page,rows);
    }

    @RequestMapping("findMenu")
    @ResponseBody
    public HashMap<String,Object> findMenu(Integer page, Integer rows,Integer powerid){
        return userService.findMenu(page,rows,powerid);
    }

    @RequestMapping("findPowerTreeList")
    @ResponseBody
    public  List<NavBean> findPowerTreeList(Integer roleid){
        return userService.findPowerTreeList(roleid);
    }

    @RequestMapping("deleteMenu")
    @ResponseBody
    public  boolean deleteMenu(Integer[] ids){
        try {
            userService.deleteMenu(ids);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("deleteRole")
    @ResponseBody
    public  boolean deleteRole(Integer[] ids){
        try {
            userService.deleteRole(ids);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
        @RequestMapping("addRole")
        @ResponseBody
    public boolean addRole(RoleBean roleBean){
            try {
                if(roleBean.getId() != null){
                    userService.updateRole(roleBean);
                }else{
                    userService.addRole(roleBean);
                }
                return true;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                return false;
            }

        }
        @RequestMapping("addMenu")
        @ResponseBody
        public boolean addMenu(MenuBean menuBean){
            try {
                if(menuBean.getId() != null){
                    userService.updateMenu(menuBean);
                }else{
                    userService.addMenu(menuBean);
                }
                return true;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                return false;
            }
        }
        @RequestMapping("editMenu")
        @ResponseBody
        public  MenuBean editMenu(Integer id){
            return userService.editMenu(id);
        }
        @RequestMapping("editRole")
        @ResponseBody
        public RoleBean editRole(Integer id){
            return userService.editRole(id);
        }
        @RequestMapping("deletePower")
        @ResponseBody
        public void deletePower(Integer powerId){
            userService.deletePower(powerId);
        }
        @RequestMapping("savePower")
        @ResponseBody
        public void savePower(NavBean tree){
            userService.savePower(tree);
        }
        @RequestMapping("saveRolePower")
        @ResponseBody
        public void saveRolePower(Integer roleId,Integer[] powerids){

        userService.saveRolePower(roleId,powerids);
        }


    @RequestMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(UserBean userBean, String veriftyCode,HttpServletRequest request){
        HashMap<String, Object> result = new HashMap<>();
        HttpSession session = request.getSession();
        //通过前台登录账号查询用户信息
        UserBean userInfo = userService.getUserInfoByLoginNumber(userBean);
        //外部webservice接口获取
        //com.jk.fs.service.webservice.UserBean userInfo = userServiceImpl.queryUserInfoLoginNumber(userBean.getLoginNumber());
        if (userInfo == null) {
            result.put("code", 2);
            result.put("msg","账号不存在");
            return result;
        }
        //判断账号状态是否正常
        if(userInfo.getStatus() != 0) {
            result.put("code", 3);
            result.put("msg","账号被锁定，请联系管理员");
            return result;
        }
        //判断密码是否正确
        String password = userBean.getPassword();
        /* String md516 = Md5Util.getMd516(password);
        System.out.println("正确密码"+md516);*/
        if (!userInfo.getPassword().equals(password)) {
            result.put("code", 4);
            result.put("msg","密码错误");
            return result;
        }
        //将用户信息存入到session当中
        session.setAttribute("user",userInfo);
        result.put("code", 0);
        result.put("msg","登录成功");
        return result;
    }






}
