package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.UserDao;
import com.jk.model.*;


import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUserList() {
        List<User> list = userDao.queryUserList();
        return list;
    }

    @Override
    public List<NavBean> findNavTreeCommon() {
        Integer id=0;
        List<NavBean> node = getNode(id);
        return node;
    }


    private List<NavBean> getNode(Integer id) {
        List<NavBean> trees=userDao.findTreeList(id);
        for (NavBean treeBean : trees) {
            Integer id2 = treeBean.getId();
            List<NavBean> nodes = getNode(id2);
            treeBean.setChildren(nodes);
        }
        return trees;
    }

    @Override
    public HashMap<String, Object> findUser(Integer page, Integer rows) {
        HashMap<String, Object> hashMap=new HashMap<>();
        int total=userDao.findUserCount();
        int start=(page-1)*rows;
        List<UserBean> list=userDao.findUserPage(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public void deleteou(Integer[] ids) {
        userDao.deleteou(ids);
    }

    @Override
    public List<DeptBean> authorSelect() {
        return userDao.authorSelect();
    }

    @Override
    public List<RoleBean> roleSelect() {
        return userDao.roleSelect();
    }

    @Override
    public void addUser(UserBean userBean) {
        Integer id = userBean.getId();
        if(id == null){

            userDao.addUser(userBean);
        }
        if(userBean.getRoleid() != null && !userBean.getRoleid().isEmpty()){
            String roleid = userBean.getRoleid();
            String[] roleArr = roleid.split(",");
            userDao.saveUserRole(userBean.getId(),roleArr);
        }
    }

    @Override
    public HashMap<String, Object> findRole(Integer page, Integer rows) {
        HashMap<String, Object> hashMap=new HashMap<>();
        int total=userDao.queryRoleBeanCount();
        int start=(page-1)*rows;
        List<RoleBean> list=userDao.findRole(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> findMenu(Integer page, Integer rows, Integer powerid) {
        HashMap<String, Object> hashMap=new HashMap<>();
        int total=userDao.queryMenuBeanCount();
        int start=(page-1)*rows;
        List<MenuBean> list=userDao.findMenu(start,rows,powerid);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public List<NavBean> findPowerTreeList(Integer roleid) {
        //根据角色id查找关联的权限
        List<NavBean> powerlist = userDao.findPowerByRoleId(roleid);
        Integer id=0;
        List<NavBean> node = getNode(id,powerlist);
        //虚拟的根节点
        NavBean navBean = new NavBean();
        navBean.setId(0);
        navBean.setText("根节点");
        navBean.setPid(-1);
        navBean.setChildren(node);
        ArrayList<NavBean> arrayList = new ArrayList<>();
        arrayList.add(navBean);
        return arrayList;
    }

    @Override
    public void deleteMenu(Integer[] ids) {
        userDao.deleteMenu(ids);
    }

    @Override
    public void deleteRole(Integer[] ids) {
        userDao.deleteRole(ids);
    }

    @Override
    public void updateRole(RoleBean roleBean) {
        userDao.updateRole(roleBean);
    }

    @Override
    public void addRole(RoleBean roleBean) {
        userDao.addRole(roleBean);
    }

    @Override
    public void updateMenu(MenuBean menuBean) {
        userDao.updateMenu(menuBean);
    }

    @Override
    public void addMenu(MenuBean menuBean) {
        userDao.addMenu(menuBean);
    }

    @Override
    public MenuBean editMenu(Integer id) {
        return userDao.editMenu(id);
    }

    @Override
    public RoleBean editRole(Integer id) {
        return userDao.editRole(id);
    }

    @Override
    public void deletePower(Integer powerId) {
        userDao.deletePower(powerId);
    }

    @Override
    public void savePower(NavBean tree) {
        userDao.savePower(tree);
    }

    @Override
    public void saveRolePower(Integer roleId, Integer[] powerids) {
        //1  删除旧的数据
        userDao.deleteRolePower(roleId);
        //2  保存新的数据
        userDao.saveRolePower(roleId,powerids);
    }

    @Override
    public UserBean getUserInfoByLoginNumber(UserBean userBean) {
        UserBean userInfoByLoginNumber = userDao.getUserInfoByLoginNumber(userBean);
        return userInfoByLoginNumber;
    }


    private List<NavBean> getNode(Integer id,List<NavBean> powerlist) {
        List<NavBean> trees=userDao.findTreeList(id);
        for (NavBean treeBean : trees) {
            Integer id2 = treeBean.getId();
            List<NavBean> nodes = getNode(id2,powerlist);
            treeBean.setChildren(nodes);
            //权限回显
            for (NavBean navBean : powerlist) {
                //是否是父级节点：如果是父节点，checked不给true
                if(nodes.size()<=0 && treeBean.getId()==navBean.getId()){
                    treeBean.setChecked(true);
                }
            }
        }
        return trees;
    }



}
