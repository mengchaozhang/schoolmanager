package com.qf.test;

import org.activiti.engine.RepositoryService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mapper.xml")
public class Test {

    @Autowired
    private RepositoryService repositoryService;

    public RepositoryService getRepositoryService() {
        return repositoryService;
    }

    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @org.junit.Test
    public void depoly(){
        repositoryService.createDeployment().addClasspathResource("holiday.bpmn").deploy();
    }
}
