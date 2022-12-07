package Pages;

import org.openqa.selenium.By;

import Base.BasePage;
import io.qameta.allure.Step;

public class DetailsVillaPage extends BasePage{
	
	By InformationRequestBTN= By.xpath("//div[@class='relative lc_tooltip lc_tooltip--hover']//button[@data-testid='inquiry-date-picker__inquiry-btn']");
	By LastNameField= By.id("inquiry-form__lastname_form-step");
	By FirstNameField= By.xpath("//input[@data-testid='inquiry-form__input-firstname']");
	By EmailField= By.id("inquiry-form__email_form-step");
	By phoneFiled= By.id("phone_undefined");
	By SendRequestBTN=By.xpath("//button[@data-testid='inquiry-form-step__send-request-unlogged']");
	
	@Step("Fill out fileds : firstName,lastName,email,phone and send request for informations")
	public void ClickOnInformationRequestBTN(String lastName ,String firstName ,String email,String phone) {
		ClickOnElement(InformationRequestBTN);
		SendKey(lastName, LastNameField);
		SendKey(firstName, FirstNameField);
		SendKey(email, EmailField);
		SendKey(phone, phoneFiled);
		//ClickOnElement(SendRequestBTN);
	}
	
}
