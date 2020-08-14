package com.semen.blog;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(
        name = "companyWithPersonProjection",
        types = {Company.class})
public interface CompanyWithPersonProjection {
    public String getCompanyName();

    public String getDep();

    public List<Person> getPerson();
}
