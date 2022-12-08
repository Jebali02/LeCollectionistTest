package Pages;

import org.openqa.selenium.By;

import Base.BasePage;
import io.qameta.allure.Step;

public class PopUpPage extends BasePage{
	
	By BTN = By.xpath("//button[@id='axeptio_btn_acceptAll']");
	
	@Step("Accept cookies")
	public void ClickOnAcceptCookies () {
		ClickOnElement(BTN);
	}

}
