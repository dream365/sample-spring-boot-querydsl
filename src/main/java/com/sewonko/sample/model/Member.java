package com.sewonko.sample.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private int id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.PERSIST, optional = false)
    private HomeAddress homeAddress;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Phone> phoneList = new ArrayList<>();

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
        homeAddress.setMember(this);
    }

    public void addPhone(Phone phone) {
        phoneList.add(phone);
        phone.setMember(this);
    }
}
