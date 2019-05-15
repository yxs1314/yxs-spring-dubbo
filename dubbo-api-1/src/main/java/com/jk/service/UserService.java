package com.jk.service;




import com.jk.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface UserService {
    List<User> queryUserList();


    List<NavBean> findNavTreeCommon();

    HashMap<String, Object> findUser(Integer page, Integer rows);

    void deleteou(Integer[] ids);

    List<DeptBean> authorSelect();

    List<RoleBean> roleSelect();

    void addUser(UserBean userBean);

    HashMap<String, Object> findRole(Integer page, Integer rows);

    HashMap<String, Object> findMenu(Integer page, Integer rows, Integer powerid);

    List<NavBean> findPowerTreeList(Integer roleid);

    void deleteMenu(Integer[] ids);

    void deleteRole(Integer[] ids);

    void updateRole(RoleBean roleBean);

    void addRole(RoleBean roleBean);

    void updateMenu(MenuBean menuBean);

    void addMenu(MenuBean menuBean);

    MenuBean editMenu(Integer id);

    RoleBean editRole(Integer id);

    void deletePower(Integer powerId);

    void savePower(NavBean tree);

    void saveRolePower(Integer roleId, Integer[] powerids);


    UserBean getUserInfoByLoginNumber(UserBean userBean);
}
