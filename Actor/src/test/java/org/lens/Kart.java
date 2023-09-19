package org.lens;
import org.pom.POM;
import org.base.BaseClass;
import org.openqa.selenium.WebElement;


public class Kart extends BaseClass {

	public static void main(String[] args) {
		initDriver("Chrome");
		getURL("https://www.ebay.com/");
		wait(5);
		//---POM object----
		POM pm=new POM();
		
		//--- Sign-in
		WebElement signIn = pm.getSignIn();
		signIn.click();
		
		//--- username
		WebElement userBox = pm.getUserBox();
		userBox.sendKeys("alexpravin0212@gmail.com");
		WebElement userContinue = pm.getUserContinue();
		userContinue.click();
		wait(3);
		
		//--- Password
		WebElement passBox = pm.getPassBox();
		passBox.sendKeys("Passingwords*13");
		WebElement login = pm.getLogin();
		login.click();
		wait(2);
		
		//--- SignOut
		WebElement moveToSignOut = pm.getMoveToSignOut();
		moveToSignOut.click();
		wait(3);
		
		WebElement signOut = pm.getSignOut();
		signOut.click();	
		
	}

}
