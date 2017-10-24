package com.kylinteam.base.entity;

import com.kylinteam.base.constant.Constant;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_user")
public class LoginUser implements Serializable {

    private static final long serialVersionUID = -721912626034105086L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account", length = Constant.DB_FIELD_LENGTH_50, nullable = false, unique = true)
    public String account;

    @Column(name = "password", length = Constant.DB_FIELD_LENGTH_50, nullable = false)
    private String password;

    @Column(name = "displayname", length = Constant.DB_FIELD_LENGTH_50)
    private String displayName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
