package Pages;

import org.openqa.selenium.By;

import Base.BasePage;

public class DetailsVillaPage extends BasePage{
	
	By InformationRequestBTN= By.xpath("//button[@data-testid='inquiry-date-picker__inquiry-btn']");
	By LastNameField= By.id("inquiry-form__lastname_form-step");
	By FirstNameField= By.xpath("//input[@data-testid='inquiry-form__input-firstname']");
	By EmailField= By.id("inquiry-form__email_form-step");
	By phoneFiled= By.id("phone_undefined");
	By SendRequestBTN=By.xpath("//button[@data-testid='inquiry-form-step__send-request-unlogged']");
	
	
	public void ClickOnInformationRequestBTN() {
		ClickOnElement(InformationRequestBTN);
	}
	public void FillLastName(String lastName) {
		SendKey(lastName, LastNameField);
	}
	public void FillFirstName(String firstName) {
		SendKey(firstName, FirstNameField);
	}
	public void FillEmail(String email) {
		SendKey(email, EmailField);
	}
	public void FillPhoneNumber(String phone) {
		SendKey(phone, phoneFiled);
	}
	public void ClickOnSendRequest() {
		ClickOnElement(SendRequestBTN);
	}
	
	public void SendRequest(String lastName, String firstName, String email, String phone)
	{
		FillFirstName(firstName);
		FillLastName(lastName);
		FillEmail(email);
		FillPhoneNumber(phone);
		//ClickOnSendRequest();
	}
	
}
