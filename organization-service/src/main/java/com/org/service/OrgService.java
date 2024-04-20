package com.org.service;

import com.org.model.Organization;
import org.springframework.stereotype.Component;

@Component
public interface OrgService {

    public Organization getOrgDetails();

}
