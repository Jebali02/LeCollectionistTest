package Pages;

import org.openqa.selenium.By;
import Base.BasePage;
import io.qameta.allure.Step;

public class HomePage extends BasePage {
	
	By SearchBox = By.xpath("//input[@id='search-input']");
	By SearchBTN = By.xpath("//button[@class='base-search__btn lc-btn--secondary lc-btn--md lc-btn lc-btn--font-bold']");
	By SearchHouseBTN=By.xpath("//a[@id='header-houses']");
	By listOFDestination=By.xpath("//div[@data-id='search-input']//div[@class='multiselect__tags']");
	By listOFSearchDestination=By.xpath("//li[@class='multiselect__element']//span[@class='flex items-center py-2 pl-8 pr-0 leading-6 whitespace-normal']");
	@Step("Search villa with destination")
	public void SearchDestination (String destination) {
		ClickOnElement(listOFDestination);
		SendKey(destination, SearchBox);
		ClickOnElement(SearchBTN);
	}
	
	public void ClickOnSearchHouse() {
		ClickOnElement(SearchHouseBTN);
	}
	
	public void SearchAndSelectDestination(String destination) {
		ClickOnElement(listOFDestination);
		SendKey(destination, SearchBox);
		SelectFromList(listOFSearchDestination, destination);

	}
}


