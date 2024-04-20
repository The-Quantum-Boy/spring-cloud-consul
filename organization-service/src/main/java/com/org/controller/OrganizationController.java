package com.org.controller;


import com.org.model.OrgResponse;
import com.org.model.Organization;
import com.org.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org")
public class OrganizationController {

    @Autowired
    public OrgService orgService;

    @GetMapping(value = "/getOrgDetails",produces = "application/json")
    public ResponseEntity<OrgResponse> getOrgDetails(){
        Organization orgDetails = orgService.getOrgDetails();
        return new ResponseEntity<>(new OrgResponse(orgDetails), HttpStatus.OK);
    }
}
