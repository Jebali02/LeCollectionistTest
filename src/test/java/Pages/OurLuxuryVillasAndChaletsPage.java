package Pages;

import org.openqa.selenium.By;
import Base.BasePage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class OurLuxuryVillasAndChaletsPage extends BasePage {


	By SearchHouseFiled=By.id("search-input");
	By CheckInBTN = By.xpath("//div[@class='datepicker__wrapper datepicker__wrapper']");
	By BudgetBTN = By.xpath("//button[@class='min-w-full w-max search-budget__button lc-outline--has-icon lc-outline--grey lc-btn--md lc-outline lc-outline--font-bold']");
	By MaxBudget=By.id("maxBudget_search-budget");
	By ApplyBTN = By.xpath("//button[@class='w-full lc-btn--secondary lc-btn--md lc-btn lc-btn--font-bold']");
	By BedroomsMinMax = By.xpath("//span[@class='font-medium truncate']");
	By nextMonthCallendarBTN=By.xpath("//button[@class='datepicker__month-button datepicker__month-button--next ']");
	By previousCallendarBTN=By.xpath("");
	By actualMonthText=By.xpath("//p[@class='datepicker__month-name']");
	By recommendedBTN=By.xpath("//div[@class='w-full col-span-2 ml-0 md:col-start-3 md:w-auto md:ml-2 search__toggle-wrap']");
	By FilterByIncreasingBed=By.xpath("//li[@class='multiselect__element']//span[contains(text(), 'Nombre de chambres croissant')]");
	By VillaNumberResult =By.xpath("//div[@class='relative lc-col w-24/24 md:w-6/24']");
	By Villa=By.xpath("//div[@class='lc-row mb-6']//div[@data-insights-position='1']");
	
	public void SeachVilla (String VillaName) {
		SendKey(VillaName, SearchHouseFiled);
	}

	public void ClickCheckInBTN () {
		ClickOnElement(CheckInBTN);
	}

	public void ClickOnNextMonthBTN() {
		ClickOnElement(nextMonthCallendarBTN);
	}

	public void ClickOnPreviousMonthBTN() {
		ClickOnElement(previousCallendarBTN);
	}

	@Step("Set arrival and departure date")
	public void SetDates(String ArrivalMonth, String ArrivalDay, String DepartureDay)
	{
		ClickCheckInBTN();
		ClickCheckInBTN();
		ClickCheckInBTN();
		boolean monthFinded=false;
		while (!monthFinded) {
			ClickOnNextMonthBTN();
			if(getText(actualMonthText).contains(ArrivalMonth))
			{
				monthFinded=true;
				ClickOnElement(By.xpath("//div[@class='datepicker__month-day-wrapper']//span[text()=\""+ArrivalDay+"\"]"));
				ClickOnElement(By.xpath("//div[@class='datepicker__month-day-wrapper']//span[text()=\""+DepartureDay+"\"]"));
			}
		}
	}
	
	@Step("Enter max budget")
	public void AddMaxBudget (String maxbudget) {
		ClickOnElement(BudgetBTN);
		SendKey(maxbudget, MaxBudget);
		ClickOnElement(ApplyBTN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Step("Filter by increasing number of rooms")
	public void ClickOnIncreasingBedFilter() {
		ClickOnElement(recommendedBTN);
		ClickOnElement(FilterByIncreasingBed);
	}
	
	@Attachment
	@Step("Get the result number of villa")
	public String GetVillaNumberResult() {
		return getText(VillaNumberResult);
	}
	@Step("Click on the first result of villa")
	public void ClickOnVilla() {
		ClickOnElement(Villa);
	}
}

