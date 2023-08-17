package com.afs.unittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_when_getExpenseCodeByProject_given_internal_project() {
        // given

        // when

        // then
    }

    @Test
    void should_return_expense_type_A_when_getExpenseCodeByProject_given_project_is_external_and_name_is_project_A() {
        // given
        Project externalProject = new Project(ProjectType.EXTERNAL, "Project A");
        ProjectService projectService = new ProjectService();
        ExpenseService expenseService = new ExpenseService(projectService);

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(externalProject);

        // then
        Assertions.assertEquals(ExpenseType.EXPENSE_TYPE_A, expenseCodeByProject);
    }

    @Test
    void should_return_expense_type_B_when_getExpenseCodeByProject_given_project_is_external_and_name_is_project_B() {
        // given
        Project externalProject = new Project(ProjectType.EXTERNAL, "Project B");
        ProjectService projectService = new ProjectService();
        ExpenseService expenseService = new ExpenseService(projectService);

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(externalProject);

        // then
        Assertions.assertEquals(ExpenseType.EXPENSE_TYPE_B, expenseCodeByProject);
    }

    @Test
    void should_return_other_expense_type_when_getExpenseCodeByProject_given_project_is_external_and_has_other_name() {
        // given
        Project externalProject = new Project(ProjectType.EXTERNAL, "Other Project");
        ProjectService projectService = new ProjectService();
        ExpenseService expenseService = new ExpenseService(projectService);

        // when
        ExpenseType expenseCodeByProject = expenseService.getExpenseCodeByProject(externalProject);

        // then
        Assertions.assertEquals(ExpenseType.OTHER_EXPENSE, expenseCodeByProject);
    }
}
