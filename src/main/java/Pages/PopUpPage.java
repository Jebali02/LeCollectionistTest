package Pages;

import org.openqa.selenium.By;

import Base.BasePage;

public class PopUpPage extends BasePage{
	
	By BTN = By.xpath("//button[@id='axeptio_btn_acceptAll']");
	
	public void ClickOnAcceptCookies () {
		ClickOnElement(BTN);
	}

}
