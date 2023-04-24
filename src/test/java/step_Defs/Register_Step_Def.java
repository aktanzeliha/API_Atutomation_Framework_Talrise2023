package step_Defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.Register;

public class Register_Step_Def {

 Register register= new Register();


    @Given("User makes request for registration with valid information")
    public void user_makes_request_for_registration_with_valid_information() {

        register.registerRequest();
    }
    @Then("User receives response and verify register with {int} status code")
    public void user_receives_response_and_verify_register_with_status_code(Integer int1) {

    }



}
