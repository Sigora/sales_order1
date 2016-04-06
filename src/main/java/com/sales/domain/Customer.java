package com.sales.domain;

import javax.persistence.*;

/**
 * Created by Sigora on 04.04.2016.
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "credit_limit")
    private Double creditLimit;

    @Column(name = "current_credit")
    private Double currentCredit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getCurrentCredit() {
        return currentCredit;
    }

    public void setCurrentCredit(Double currentCredit) {
        this.currentCredit = currentCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(id, customer.id)
                .append(code, customer.code)
                .append(name, customer.name)
                .append(phone1, customer.phone1)
                .append(phone2, customer.phone2)
                .append(creditLimit, customer.creditLimit)
                .append(currentCredit, customer.currentCredit)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(id)
                .append(code)
                .append(name)
                .append(phone1)
                .append(phone2)
                .append(creditLimit)
                .append(currentCredit)
                .toHashCode();
    }
}
