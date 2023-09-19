package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class POM extends BaseClass {
	
	
	public POM() {
		PageFactory.initElements(driver, this);
	}
	
	//-- sign-in
	@FindBy(xpath="(//a[text()='Sign in'])[1]")
	private WebElement signIn;
	
	public WebElement getSignIn() {
		return signIn;
	}
	
	//--- username
	@FindBy(css="#userid")
	private WebElement userBox;
	
	public WebElement getUserBox() {
		return userBox;
	}
	
	
	@FindBy(css="#signin-continue-btn")
	private WebElement userContinue;
	
	public WebElement getUserContinue() {
		return userContinue;
	}
	//-- password
	@FindBy(css="#pass")
	private WebElement passBox;
	
	public WebElement getPassBox() {
		return passBox;
	}

	@FindBy(css="#sgnBt")
	private WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
	
	//--Sign-Out
	@FindBy(xpath="(//button[@aria-expanded='false'])[2]")
	private WebElement moveToSignOut;
	
	public WebElement getMoveToSignOut() {
		return moveToSignOut;
	}
	//*[text()='Alex']
	//
	@FindBy(css="*[_sp='m570.l2622']")
	private WebElement signOut;
	
	public WebElement getSignOut() {
		return signOut;
	}
	
	
	
}
