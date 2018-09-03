package cn.zou.shopping.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Role {
    private Long rId;

    private String name;

    private String roleDesc;

    private Date uptime;

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Role() {
    }

    public Role(String name, String roleDesc) {
        this.name = name;
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "rId=" + rId +
                ", name='" + name + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", uptime=" + uptime +
                '}';
    }
}