package com.xxh.web.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * @author 小小黑
 */
public class WorkInFormVO {
    public interface Update {}
    public interface Add {}

    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    private Long id;

    @Size(groups = {Add.class}, min = 3, max = 20)
    private String name;

    @Email(groups = {Add.class})
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "WorkInFormVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
