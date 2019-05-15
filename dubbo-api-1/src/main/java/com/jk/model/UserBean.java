package com.jk.model;

import java.io.Serializable;

public class UserBean implements Serializable {

    private static final long serialVersionUID = -5790621868286163279L;
    private Integer id;

    private String name;

    private String account;

    private Integer age;

    private Integer startage;

    private Integer endage;

    private String password;

    private Integer deptid;

    private String deptname;

    private Integer sex;


    private Integer province;

    private String provincename;

    private Integer city;

    private String cityname;

    private Integer status;

    private String roleid;

    private String rolename;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStartage() {
        return startage;
    }

    public void setStartage(Integer startage) {
        this.startage = startage;
    }

    public Integer getEndage() {
        return endage;
    }

    public void setEndage(Integer endage) {
        this.endage = endage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", age=" + age +
                ", startage=" + startage +
                ", endage=" + endage +
                ", password='" + password + '\'' +
                ", deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                ", sex=" + sex +
                ", province=" + province +
                ", provincename='" + provincename + '\'' +
                ", city=" + city +
                ", cityname='" + cityname + '\'' +
                ", status=" + status +
                ", roleid='" + roleid + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
