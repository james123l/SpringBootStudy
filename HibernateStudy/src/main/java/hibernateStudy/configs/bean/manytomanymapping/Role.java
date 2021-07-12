package hibernateStudy.configs.bean.manytomanymapping;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Integer role_id;
    private String role_name;
    //一个角色有多个用户
    private Set<GameUser> userSet = new HashSet<>();

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<GameUser> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<GameUser> userSet) {
        this.userSet = userSet;
    }
}
