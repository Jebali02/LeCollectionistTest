package Pages;

import org.openqa.selenium.By;
import Base.BasePage;

public class HomePage extends BasePage {
	
	By SearchBox = By.xpath("//input[@id='search-input']");
	By SearchBTN = By.xpath("//button[@class='base-search__btn lc-btn--secondary lc-btn--md lc-btn lc-btn--font-bold']");
	By SearchHouseBTN=By.xpath("//a[@id='header-houses']");
	By listOFDestination=By.xpath("//div[@data-id='search-input']//div[@class='multiselect__tags']");
	
	public void SearchDestination (String destination) {
		ClickOnElement(listOFDestination);
		SendKey(destination, SearchBox);
		ClickSearch();
		//ClickOnElement(listOFDestination);
		//SendKey(destination, SearchBox);
		//ClickSearch();
	}
	
	public void SearchAndSelectDestination (String destination) {
		ClickOnElement(By.xpath("//div[@data-id='search-input']//div[@class='multiselect__tags']"));
		SendKey(destination, SearchBox);
	}
	public void ClickSearch() {
		ClickOnElement(SearchBTN);
	}
	public void SelectFirstResultFromList() {
		ClickOnElement(By.xpath("//div[@class='search-input']//li[@class='multiselect__element'][2]//span//span"));
	}
	public void ClickOnSearchHouse() {
		ClickOnElement(SearchHouseBTN);
	}
	
}

