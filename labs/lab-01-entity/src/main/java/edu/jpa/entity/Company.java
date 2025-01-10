package edu.jpa.entity;

import jakarta.persistence.*;

@Table(name = "COMPANY")
@SecondaryTable(name = "COMPANY_DETAILS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID"))
@Entity
public class Company {
    @Id
    @Column(name = "COMPANY_ID")
    private int id;

    @Column(name = "COMPANY_NAME", table = "COMPANY", columnDefinition = "varchar(50)")
    private String name;

    @Column(name = "COMPANY_ADDRESS", table = "COMPANY_DETAILS", columnDefinition = "varchar(100)")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
