package com.jk.dao;

import com.jk.model.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    @Select("select * from t_user1")
    List<User> queryUserList();


    @Select("select * from t_nav where pid=#{value}")
    List<NavBean> findTreeList(Integer id);

    @Select("select count(1) from t_user u " +
            "        left join t_dept a on u.deptid=a.id " +
            "        left join t_area  c on u.province=c.id " +
            "        left join t_area c1 on u.city=c1.id " +
            "        left join t_user_role ur on u.id=ur.userid " +
            "        left join t_role r on r.id=ur.roleid")
    int findUserCount();

    @Select("select u.id,u.name,u.account,u.password,u.sex,u.age,u.status,a.name as deptname,c.name as provincename,c1.name as cityname,group_concat(r.name) rolename from t_user u " +
            "        left join t_dept  a on u.deptid=a.id " +
            "        left join t_area  c on u.province=c.id " +
            "        left join t_area c1 on u.city=c1.id " +
            "        left join t_user_role ur on u.id=ur.userid " +
            "        left join t_role r on r.id=ur.roleid " +
            "        group by u.id " +
            "        limit  #{start},#{rows}")
    List<UserBean> findUserPage(@Param("start") int start, @Param("rows") Integer rows);


    void deleteou(Integer[] ids);

    @Select("select id,name as text from t_dept")
    List<DeptBean> authorSelect();

    @Select("select * from t_role")
    List<RoleBean> roleSelect();

    void addUser(UserBean userBean);

    void saveUserRole(@Param("id") Integer id, @Param("roleArr") String[] roleArr);

    @Select("select count(1) from t_role r")
    int queryRoleBeanCount();

    @Select(" select r.id,r.name,r.info from t_role r " +
            "    limit  #{start},#{rows} ")
    List<RoleBean> findRole(@Param("start") int start, @Param("rows") Integer rows);

    List<NavBean> findPowerByRoleId(Integer roleid);

    int queryMenuBeanCount();

    List<MenuBean> findMenu(@Param("start") int start, @Param("rows") Integer rows,@Param("powerid") Integer powerid);

    void deleteMenu(Integer[] ids);

    void deleteRole(Integer[] ids);

    void updateRole(RoleBean roleBean);

    void addRole(RoleBean roleBean);

    void addMenu(MenuBean menuBean);

    void updateMenu(MenuBean menuBean);

    MenuBean editMenu(Integer id);

    RoleBean editRole(Integer id);

    void deletePower(Integer powerId);

    void savePower(NavBean tree);

    void deleteRolePower(Integer roleId);

    void saveRolePower(@Param("roleId") Integer roleId, @Param("powerArr") Integer[] powerids);


    UserBean getUserInfoByLoginNumber(UserBean userBean);
}
