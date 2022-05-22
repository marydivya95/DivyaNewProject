package StepDefinations;

import SeleniumCode.AT04_CreatAnAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class SD04_CreatAnAccount {
    @Given("User navigates to Create an account screen")
    public void user_navigates_to_create_an_account_screen() throws IOException {
        AT04_CreatAnAccount.NavCreateAcc();
}
    @Then("Enter Valid {string}, {string}, {string}")
    public void enter_valid(String FirstName, String LastName, String emailAddress) throws IOException {
        AT04_CreatAnAccount.EnterAccDetials(FirstName,LastName,emailAddress);
    }

}
