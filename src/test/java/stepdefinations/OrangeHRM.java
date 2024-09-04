package stepdefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRM 
{
	String empid;
	public static WebDriver driver;

	@Given("i open browser with url {string}")
	public void i_open_browser_with_url(String url) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Then("i should see login page")
	public void i_should_see_login_page() {
		if (driver.findElement(By.id("btnLogin")).isDisplayed()) {
			System.out.println("System displayed Login Page:");
		}
	}

	@When("i enter user name as {string}")
	public void i_enter_user_name_as(String uname) {
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
	}

	@When("i enter password as {string}")
	public void i_enter_password_as(String pword) {
		driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}

	@When("i click login")
	public void i_click_login() {
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("i should see admin module")
	public void i_should_see_admin_module() {
		if (driver.findElement(By.linkText("Admin")).isDisplayed()) {
			System.out.println("System Displayed Admin Module:");
		}
	}

	@When("i click logout")
	public void i_click_logout() {
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();

	}
	
	@When("i close browser")
	public void i_close_browser() {
		driver.close();
	}
	@Then("i should see errormessage")
	public void i_should_see_errormessage() {

		String errmsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();
		
		if(errmsg.contains("invalid") || errmsg.contains("empty"))
		{
			System.out.println("System displayed ErrorMessage:");
		}
	}
	
	//New Employee Registration
	@When("i goto add employee page")
	public void i_goto_add_employee_page()
	{
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();   
	}
	@When("i enter firstname as {string}")
	public void i_enter_firstname_as(String fname) 
	{
		driver.findElement(By.id("firstName")).sendKeys(fname);
	
	}
	@When("i enter lasname as {string}")
	public void i_enter_lasname_as(String lname)
	{
		driver.findElement(By.id("lastName")).sendKeys(lname);
	
	}
	@When("i click save")
	public void i_click_save() 
	{
		empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
	}
	@Then("i should see new employee registered in employee list")
	public void i_should_see_new_employee_registered_in_employee_list() 
	{
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
		
		WebElement emptable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows = emptable.findElements(By.tagName("tr"));
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(empid))
			{
				System.out.println("New Employee Registration successfully added.");		
			}
		}
	}
}
