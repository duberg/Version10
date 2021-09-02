package stepDefinitions;

import common.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ResultsSteps {
    Calculator calc = new Calculator();
    private int trackResult;
    private int lengthResult;

    @Given("I have entered track {double} in seconds for {string}")
    public void i_have_entered_track_in_seconds_for(double result, String branch) {
        calc.setTrackSeconds(result);
        calc.whichBranchMen(branch);

    }

    @When("I ask for results")
    public void i_ask_for_results() {
        trackResult = calc.getTrackResults();
    }

    @Then("I should get track {int} back")
    public void i_should_get_track_back(int points) {
        Assert.assertEquals(points, trackResult);
    }

    @Given("I ask for cm {double} for {string}")
    public void i_ask_for_cm_for(double cm, String branch) {
        calc.setCurrentLength(cm);
        calc.whichBranchMen(branch);

    }

    @When("I ask for cm results")
    public void i_ask_for_cm_results() {
        lengthResult = calc.getLengthResults();
    }

    @Then("I should get cm {int} back")
    public void i_should_get_cm_back(int points) {
        Assert.assertEquals(points, lengthResult);
    }

    @Given("I have entered women track {double} in seconds for {string}")
    public void i_have_entered_women_track_in_seconds_for(double results, String branch) {
        calc.setTrackSeconds(results);
        calc.whichBranchWomen(branch);


    }

    @Given("I ask for cm {double} for women {string}")
    public void i_ask_for_cm_for_women(Double result, String branch) {
        calc.setCurrentLength(result);
        calc.whichBranchWomen(branch);
    }


    @Given("I ask for {int} and {int} for {string} for {string}")
    public void i_ask_for_and_for_for(int minutes, int seconds, String branch, String gender) {
        calc.setMinutes(minutes);
        calc.setSeconds(seconds);
        if (gender.equals("Male")) {
            calc.whichBranchMen(branch);
        } else if (gender.equals("Female")) {
            calc.whichBranchWomen(branch);
        }
    }

}
