package com.sewonko.sample.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "HOME_ADDRESS")
public class HomeAddress {

    @Id
    private int id;

    private String address;

    @OneToOne(optional = false)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
