package Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import Base.BasePage;
import Pages.DetailsVillaPage;
import Pages.HomePage;
import Pages.OurLuxuryVillasAndChaletsPage;
import Pages.PopUpPage;

public class ResearchAndInformationTest extends BasePage {

	HomePage homePage =new HomePage();
	PopUpPage popupPage=new PopUpPage();
	OurLuxuryVillasAndChaletsPage ourLuxuryVillasAndChaletsPage=new OurLuxuryVillasAndChaletsPage();
	DetailsVillaPage detailsVillaPage = new DetailsVillaPage();

	@Test
	public void SearchVilla() {
		logger.info("I am inside test SearchVilla");
		popupPage.ClickOnAcceptCookies();
		homePage.SearchDestination(readPropertiesFile("Destination"));
		ourLuxuryVillasAndChaletsPage.SetDates(readPropertiesFile("ArrivalMonth"),readPropertiesFile("ArrivalDay"),readPropertiesFile("DepartureDay"));
		ourLuxuryVillasAndChaletsPage.ClickBudgetBTN();
		ourLuxuryVillasAndChaletsPage.AddMaxBudget(readPropertiesFile("MaxBudget"));
		ourLuxuryVillasAndChaletsPage.ClickApplyBTN();
		
		Reporter.log("Le nombre de résultat est le suivant : " + ourLuxuryVillasAndChaletsPage.GetVillaNumberResult());

		ourLuxuryVillasAndChaletsPage.ClickOnRecommened();
		ourLuxuryVillasAndChaletsPage.ClickOnIncreasingBedFilter();
		ourLuxuryVillasAndChaletsPage.GetVillaNumberResult();
		ourLuxuryVillasAndChaletsPage.ClickOnVilla();
		
		detailsVillaPage.ClickOnInformationRequestBTN();
		detailsVillaPage.SendRequest(readPropertiesFile("Prenom"),readPropertiesFile("Nom"),readPropertiesFile("Phone"),readPropertiesFile("email"));
	

	}

}
