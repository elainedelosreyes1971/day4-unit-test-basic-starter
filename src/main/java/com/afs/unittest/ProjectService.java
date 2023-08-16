package com.afs.unittest;

public class ProjectService {
    public boolean isProjectTypeValid(ProjectType projectType) {
        // some pseudo work: connect db ...
        // some pseudo work: call another http service ...
        return projectType == ProjectType.EXTERNAL || projectType == ProjectType.INTERNAL;
    }
}
