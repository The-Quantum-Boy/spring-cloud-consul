package com.org.service.impl;

import com.org.model.Organization;
import com.org.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgServiceImpl implements OrgService {


    @Override
    public Organization getOrgDetails() {
        return new Organization(1,"NEML");
    }
}
