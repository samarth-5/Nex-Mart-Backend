package com.samarth_dev.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samarth_dev.domain.USER_ROLE;
import com.sun.source.doctree.UsesTree;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;

    private String email;

    private String fullName;

    private String mobile;

    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    private Set<Address> addresses = new HashSet<>();

    private Set<Coupon> usedCoupons = new HashSet<>();
}
