package hibernateStudy.configs.bean.manytomanymapping;


import java.util.HashSet;
import java.util.Set;

public class GameUser {
    private Integer user_id;
    private String user_name;
    private String user_password;
    //一个游戏用户可以有多个角色
    private Set<Role> roleSet = new HashSet<>();

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
