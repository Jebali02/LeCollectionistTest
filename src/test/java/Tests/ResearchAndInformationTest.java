package Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import Base.BasePage;
import Pages.DetailsVillaPage;
import Pages.HomePage;
import Pages.OurLuxuryVillasAndChaletsPage;
import Pages.PopUpPage;
import Utilities.DataUtil;

public class ResearchAndInformationTest extends BasePage {

	HomePage homePage =new HomePage();
	PopUpPage popupPage=new PopUpPage();
	OurLuxuryVillasAndChaletsPage ourLuxuryVillasAndChaletsPage=new OurLuxuryVillasAndChaletsPage();
	DetailsVillaPage detailsVillaPage = new DetailsVillaPage();

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void SearchVilla(String destination,String ArrivalMonth,String ArrivalDay,String DepartureDay,String MaxBudget, String Prenom, String Nom, String Phone, String email) {

		logger.info("I am inside test SearchVilla");
		
		logger.info(destination);
		logger.info(ArrivalMonth);
		logger.info(ArrivalDay);
		logger.info(DepartureDay);
		logger.info(MaxBudget);
		logger.info(Prenom);
		logger.info(Nom);

		popupPage.ClickOnAcceptCookies();
		homePage.SearchDestination(destination);
		ourLuxuryVillasAndChaletsPage.SetDates(ArrivalMonth,ArrivalDay,DepartureDay);
		ourLuxuryVillasAndChaletsPage.ClickBudgetBTN();
		ourLuxuryVillasAndChaletsPage.AddMaxBudget(MaxBudget);
		ourLuxuryVillasAndChaletsPage.ClickApplyBTN();
		
		Reporter.log("Le nombre de résultat est le suivant : " + ourLuxuryVillasAndChaletsPage.GetVillaNumberResult());

		ourLuxuryVillasAndChaletsPage.ClickOnRecommened();
		ourLuxuryVillasAndChaletsPage.ClickOnIncreasingBedFilter();
		ourLuxuryVillasAndChaletsPage.GetVillaNumberResult();
		ourLuxuryVillasAndChaletsPage.ClickOnVilla();
		
		detailsVillaPage.ClickOnInformationRequestBTN();
		detailsVillaPage.SendRequest(Prenom,Nom,Phone,email);
	
	}

}
