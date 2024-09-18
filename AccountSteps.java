package glue;

import account.Account;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.math.BigDecimal;
import java.util.Map;

public class AccountSteps {

    Account account = null;
    
    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void accountExistsForAccNoWithName(String number, String name) {
        // create a new account
    	System.out.println("CREATING ACCOUNT");
        account = new Account(number, name);
    }
    
    @Given("deposits are made")
    public void deposits_are_made(io.cucumber.datatable.DataTable dataTable) {

    	// Creates deposits to the account
    	// The deposits given by the dataTable are converted into a map of string and big decimal values.
    	// Used big decimal values to remove arithemetic addition and subtraction errors
    	System.out.println("MAKING DEPOSIT");
    	Map<String, BigDecimal> deposits = dataTable.asMap(String.class, BigDecimal.class);
    	account.getDeposits(deposits);
    }

    @Given("withdrawls are made")
    public void withdrawls_are_made(io.cucumber.datatable.DataTable dataTable) {

    	// input gives the withdrawl which contains the amount withdrawled
    	// the amount withdrawn will be removed from the current balance
    	System.out.println("WITHDRAWL");
    	
    	Map<String, BigDecimal> withdrawl = dataTable.asMap(String.class, BigDecimal.class);
    	account.makeWithdrawl(withdrawl);
    }

    @When("statement is produced")
    public void statement_is_produced() {
        // Creates a statement which includes the name, account number and total balance
    	// prints out each value
    	System.out.println("STATEMENT CREATED");
    	
    	account.createStatement();
    }

    @Then("statement includes {string}")
    public void statement_includes(String string) {
        // Given the transaction code it returns the transaction code
    	// and the amount of that given transaction and prints each value
    	System.out.println("INDIVIDUAL STATEMENT");
	
    	account.printStatement(string);
    }
}
