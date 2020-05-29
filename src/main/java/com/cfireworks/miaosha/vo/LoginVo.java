package com.cfireworks.miaosha.vo;

import com.cfireworks.miaosha.validator.IsMobile;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @description: login info
 * @author: cfireworks
 * @create: 2020-04-30 20:20
 **/
public class LoginVo {
    @NotNull
    @IsMobile
    String mobile;

    @NotNull
    @Length(min=32)
    String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
