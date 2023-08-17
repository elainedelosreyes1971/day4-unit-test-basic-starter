package com.afs.unittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_when_getExpenseCodeByProject_given_internal_project() {
        // given
        Project internalProject = new Project(ProjectType.INTERNAL, "Project Internal");
        ProjectService projectService = new ProjectService();
        ExpenseService expenseService = new ExpenseService(projectService);

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(internalProject);

        // then
        Assertions.assertEquals(ExpenseType.INTERNAL_PROJECT_EXPENSE, expenseCodeByProject);
    }

    @Test
    void should_return_expense_type_A_when_getExpenseCodeByProject_given_project_is_external_and_name_is_project_A() {
        // given
        Project externalProjectA = new Project(ProjectType.EXTERNAL, "Project A");
        ProjectService projectService = new ProjectService();
        ExpenseService expenseService = new ExpenseService(projectService);

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(externalProjectA);

        // then
        Assertions.assertEquals(ExpenseType.EXPENSE_TYPE_A, expenseCodeByProject);
    }

    @Test
    void should_return_expense_type_B_when_getExpenseCodeByProject_given_project_is_external_and_name_is_project_B() {
        // given
        Project externalProjectB = new Project(ProjectType.EXTERNAL, "Project B");
        ProjectService projectService = new ProjectService();
        ExpenseService expenseService = new ExpenseService(projectService);

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(externalProjectB);

        // then
        Assertions.assertEquals(ExpenseType.EXPENSE_TYPE_B, expenseCodeByProject);
    }

    @Test
    void should_return_other_expense_type_when_getExpenseCodeByProject_given_project_is_external_and_has_other_name() {
        // given
        Project otherExternalProject = new Project(ProjectType.EXTERNAL, "Other Project");
        ProjectService projectService = new ProjectService();
        ExpenseService expenseService = new ExpenseService(projectService);

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(otherExternalProject);

        // then
        Assertions.assertEquals(ExpenseType.OTHER_EXPENSE, expenseCodeByProject);
    }
}
