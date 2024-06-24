package com.lrne.bank.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank")
public class Client {

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_branch")
    private String bankBranch;

    @Column(name = "account_holder_name")
    private String accHolderName;

    @Column(name = "account_number")
    private String accNumber;

    @Column(name =  "mobile_number")
    private String accMobileNumber;

    @Id
    @Column(name = "account_holder_email")
    private String accHolderEmail;

}
