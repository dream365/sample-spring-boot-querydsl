package com.sewonko.sample.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PHONE")
public class Phone {

    @Id
    private int id;

    private String number;

    private String manufacture;

    public Phone(int id, String number, String manufacture) {
        this.id = id;
        this.number = number;
        this.manufacture = manufacture;
    }

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
