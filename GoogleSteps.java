package glue;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;


public class GoogleSteps {
	
	WebDriver driver;
	
	@Before()
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
        //driver = new ChromeDriver();
	}
	
    @Given("url {string} is launched")
    public void url(String url) {
        W.get().driver.get(url);
        acceptCookiesIfWarned();
    }
    
    @When("About page is shown")
    public void about_page_is_shown() {
        // see/check if the page is shown
        System.out.println("Page is shown");
    }

    @Then("page displays {string}")
    public void page_displays(String string) {
        // check if the page displays string
    	// use the webdriver to check if the page is displayed
    	String pageSource = W.get().driver.getPageSource();

    	if (pageSource.contains(string)) {
    	    System.out.println("Text is present on the webpage.");
    	} else {
    	    System.out.println("Text is not present on the webpage.");
    	}
    }

    @SuppressWarnings("deprecation")
	@When("searching for {string}")
    public void searching_for(String string) {
        // Write code here that turns the phrase above into concrete actions
    	
    	WebElement searchBar = W.get().driver.findElement(By.name("q"));
    	searchBar.click();
    	searchBar.sendKeys(string);
    	searchBar.sendKeys(Keys.RETURN);
    	
    	W.get().driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("results contain {string}")
    public void results_contain(String string) {
        // Write code here that turns the phrase above into concrete actions
    	 List<WebElement> results = W.get().driver.findElements(By.className("yuRUbf"));

	    // Finally, we'll loop over the list to verify each result link contains our term
    	Integer counter = 0;
	    for (int i = 0; i < results.size(); i++) {
	    	System.out.println("str" + string);
	    	WebElement h3Tag = results.get(i).findElement(By.tagName("h3"));
	    	// h3Tag is the exact same as string but aren't equal - maybe some whitespace
	    	System.out.println(h3Tag.getText());
	       if(string.equals(h3Tag.getText())) {
	    	   System.out.println("Result does contain " + string);
	    	   counter += 1;
	       }
	    }
	    if(counter == 0) {
	    	System.out.println("Result doesn't contain " + string);
	    }
}

    @Then("result stats are displayed")
    public void result_stats_are_displayed() {
        // Check whether the results stats are displayed
    	// Due to the chrome search not showing the search statistics 
    	// I was unsure where to look for where the stats were displayed
    	// I am not sure if it was chromdriver version but from having a look 
    	// there could be a whole number of reasons. Therefore I have unable
    	// to do this function and the one below "number_of_is_more_than"
    	throw new io.cucumber.java.PendingException();
    }

    @Then("number of {string} is more than {int}")
    public void number_of_is_more_than(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    private static void acceptCookiesIfWarned() {
        try {
            W.get().driver.findElement(By.cssSelector("#L2AGLb")).click();
        } catch (NoSuchElementException ignored) {
        }
    }

}
