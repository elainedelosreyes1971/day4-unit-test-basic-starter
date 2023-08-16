package com.afs.unittest;
import com.afs.unittest.exception.UnexpectedProjectTypeException;
import static com.afs.unittest.ExpenseType.*;

class ExpenseService {
    private ProjectService projectService;

    ExpenseService(ProjectService projectService) {
        this.projectService = projectService;
    }

    ExpenseType getExpenseCodeByProject(Project project) throws UnexpectedProjectTypeException {
        ProjectType projectType = project.getProjectType();
        if (!projectService.isProjectTypeValid(projectType)) {
            throw new UnexpectedProjectTypeException("You enter invalid project type");
        }
        if (projectType == ProjectType.INTERNAL) {
            return INTERNAL_PROJECT_EXPENSE;
        }
        if (projectType == ProjectType.EXTERNAL) {
            String projectName = project.getProjectName();
            if (projectName.equals("Project A")) {
                return EXPENSE_TYPE_A;
            }
            if (projectName.equals("Project B")) {
                return EXPENSE_TYPE_B;
            }
        }
        return OTHER_EXPENSE;
    }
}
