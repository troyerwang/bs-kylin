package com.kylinteam.base.entity;

import com.kylinteam.base.common.constant.Constant;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by troy on 2017/11/8.
 */
@Entity
@Table(name = "tb_user_detail")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = -8721412673202148361L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address", length = Constant.DB_FIELD_LENGTH_50, nullable = false)
    private String address;

    @Column(name = "phone", length = Constant.DB_FIELD_LENGTH_50, nullable = false)
    private String phone;

    @ManyToOne(targetEntity = LoginUser.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "userId", nullable = true)
    private LoginUser user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
