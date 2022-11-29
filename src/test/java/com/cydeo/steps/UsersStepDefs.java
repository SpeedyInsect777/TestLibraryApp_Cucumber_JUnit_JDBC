package com.cydeo.steps;

import com.cydeo.pages.UsersPage;
import com.cydeo.utility.BrowserUtil;
import io.cucumber.java.en.*;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.support.ui.Select;

public class UsersStepDefs {

    UsersPage usersPage=new UsersPage();
    String email;

    @When("the user clicks Edit User button")
    public void the_user_clicks_edit_user_button() {
        BrowserUtil.waitFor(2);
        usersPage.editUser.click();
    }
    @When("the user changes user status {string} to {string}")
    public void the_user_changes_user_status_to(String active, String inactive) {
        BrowserUtil.waitFor(2);

       /* Select select=new Select(usersPage.statusDropdown);
        select.selectByVisibleText(inactive);*/

        BrowserUtil.selectByVisibleText(usersPage.statusDropdown,inactive);

        email = usersPage.email.getAttribute("value");
        System.out.println("email = " + email);

        BrowserUtil.waitFor(2);


    }
    @When("the user clicks save changes button")
    public void the_user_clicks_save_changes_button() {

        usersPage.saveChanges.click();
        System.out.println("----> Users "+email+" is deactivated");

    }
    @Then("{string} message should appear")
    public void message_should_appear(String expectedMessage) {
        // Maybe this message will appear dynamicly.In that case  you need to handle time issue with Explicit Wait
        BrowserUtil.waitFor(1);
        String actualMessage = usersPage.toastMessage.getText();

    }
    @Then("the users should see same status for related user in database")
    public void the_users_should_see_same_status_for_related_user_in_database() {

    }
    @Then("the user changes current user status {string} to {string}")
    public void the_user_changes_current_user_status_to(String string, String string2) {

    }
}