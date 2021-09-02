package stepDefinitions;

import common.Competitor;
import common.UserInput;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    Competitor comp = new Competitor();

    @Given("I have also entered gender{string} and {int} is assigned")
    public void iHaveAlsoEnteredGenderAndSheetNumIsAssigned(String gender, int sheetNum) {
        String output = comp.getUserGender(gender, sheetNum);
    }

    @Then("result {string} should be displayed on the screen for gender {string} and {int}")
    public void result_should_be_displayed_on_the_screen_for_gender_and(String result, String gender, int sheetNum) {
        String output = comp.getUserGender(gender, sheetNum);
        Assert.assertEquals(result, output);
    }

    @Given("I have entered firstname {string} and  {int} is assigned")
    public void i_have_entered_firstname_and_is_assigned(String firstName, int sheetNum) {
        String output = comp.getUserFirstName(firstName, sheetNum);

    }

    @When("I press enter")
    public void i_press_enter() {
    }

    @Then("then {string} should be displayed on the screen for firstname {string} and {int}")
    public void then_should_be_displayed_on_the_screen_for_firstname_and(String result, String firstName, int sheetNum) {
        String output = comp.getUserFirstName(firstName, sheetNum);
        Assert.assertEquals(result, firstName);

    }

    @Given("I have also entered lastname {string} and {int} is assigned")
    public void i_have_also_entered_lastname_and_is_assigned(String lastName, int sheetNum) {
        String output = comp.getUserLastName(lastName, sheetNum);
        Assert.assertEquals(lastName, output);

    }

    @Then("then {string} should be displayed on the screen for lastname {string} and {int}")
    public void then_should_be_displayed_on_the_screen_for_lastname_and(String result, String lastName, int sheetNum) {
        String output = comp.getUserLastName(lastName, sheetNum);
        Assert.assertEquals(result, output);
    }

    @Given("I have ssn{int} and {int} is assigned")
    public void i_have_ssn_and_is_assigned(Integer ssn, int sheetNum) {
        int output = comp.getUserSsn(ssn, sheetNum);

    }

    @Then("{int} should be displayed on the screen for ssn {int} and {int}")
    public void should_be_displayed_on_the_screen_for_ssn_and(int result, int ssn, int sheetNum) {
        int output = comp.getUserSsn(ssn, sheetNum);
        System.out.println(output);
        Assert.assertEquals(result, output);
    }


    @Given("rowNumber is {int}")
    public void row_number_is(int int1) {

    }

    @And("I am gender {string}")
    public void iAmGender(String arg0) {
    }

    @Then("{string} should be displayed on the screen for row {int}")
    public void should_be_displayed_on_the_screen_for_row(String string, int int1) {
    }


}