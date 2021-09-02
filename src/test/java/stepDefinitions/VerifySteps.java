package stepDefinitions;

import common.UserInput;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class VerifySteps {
    UserInput user = new UserInput();


    @Given("I have entered {string}")
    public void i_have_entered(String gender) {
        String output = user.verifyGender(gender);
    }


    @Then("gender {string} should be displayed on the screen {string}")
    public void genderShouldBeDisplayedOnTheScreen(String result, String gender) {
        String output = user.verifyGender(gender);
        Assert.assertEquals(result, output);
    }

    @Given("I have entered firstname {string}")
    public void i_have_entered_firstname(String firstName) {
        String output = user.verifyStringInput(firstName);
    }

    @Then("firstname {string} should be displayed on the screen {string}")
    public void firstname_should_be_displayed_on_the_screen(String result, String firstName) {
        String output = user.verifyStringInput(firstName);
        Assert.assertEquals(result, output);
    }

    @Given("I have entered lastname {string}")
    public void i_have_entered_lastname(String lastName) {
        String output = user.verifyStringInput(lastName);
    }

    @Then("lastname {string} should be displayed on the screen {string}")
    public void lastname_should_be_displayed_on_the_screen(String result, String lastName) {
        String output = user.verifyStringInput(lastName);
        Assert.assertEquals(result, output);
    }

    @Given("I have typed ssn {int}")
    public void i_have_typed_ssn(int ssn) {
        user.verifyIntInput(ssn);

    }

    @Then("ssn {int} should be displayed on the screen for ssn {int}")
    public void ssn_should_be_displayed_on_the_screen_for_ssn(int result, int ssn) {
        int output = user.verifyIntInput(ssn);
        Assert.assertEquals(result, output);


    }

}

