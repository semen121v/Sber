package com.semen.blog;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "dep")
    private String Dep;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<Person> person;

    public Company(String companyName, String dep) {
        this.companyName = companyName;
        Dep = dep;
    }

    public Company() {
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDep() {
        return Dep;
    }

    public void setDep(String Dep) {
        this.Dep = Dep;
    }


}
