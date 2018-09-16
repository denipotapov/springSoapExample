package com.personal.info.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import personal.com.schema.PersonalInfo;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonalInfoRepository {

    private static final Map<String, PersonalInfo> applicants = new HashMap<>();

    @PostConstruct
    public void initData() {
        PersonalInfo denis = new PersonalInfo();
        denis.setFirstName("Denis");
        denis.setLastName("Potapov");
        denis.setMiddleName("Aleksandrovich");
        denis.setCvLink("https://spb.hh.ru/resume/3d3ac775ff0327b22d0039ed1f54554e385a65");

        applicants.put(denis.getFirstName(), denis);
    }

    public PersonalInfo findApplicant(String name) {
        Assert.notNull(name, "The applicant's name must not be null");
        return applicants.get(name);
    }

}
