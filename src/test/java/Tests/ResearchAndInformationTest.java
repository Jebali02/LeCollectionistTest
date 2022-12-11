package Tests;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.BasePage;
import Pages.DetailsVillaPage;
import Pages.HomePage;
import Pages.OurLuxuryVillasAndChaletsPage;
import Pages.PopUpPage;
import Utilities.DataUtil;
import Utilities.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({ TestListener.class })
@Feature("Search a villa from distination")
public class ResearchAndInformationTest extends BasePage {

	HomePage homePage =new HomePage();
	PopUpPage popupPage=new PopUpPage();
	OurLuxuryVillasAndChaletsPage ourLuxuryVillasAndChaletsPage=new OurLuxuryVillasAndChaletsPage();
	DetailsVillaPage detailsVillaPage = new DetailsVillaPage();
	
	
	@Description("This test allow to search a villa from destination by entering arrival date, departure date and budget")
	@Severity(SeverityLevel.NORMAL)
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp1")
	public void SearchVilla(String destination,String ArrivalMonth,String ArrivalDay,String DepartureDay,String MaxBudget, String Prenom, String Nom, String Phone, String email) {

		logger.info("Start : I am inside test SearchVilla");
		
		homePage.SearchAndSelectDestination(destination);
		ourLuxuryVillasAndChaletsPage.SetDates(ArrivalMonth,ArrivalDay,DepartureDay);
		ourLuxuryVillasAndChaletsPage.AddMaxBudget(MaxBudget);
		ourLuxuryVillasAndChaletsPage.ClickOnIncreasingBedFilter();
		Reporter.log("Le nombre de r�sultat est le suivant : " + ourLuxuryVillasAndChaletsPage.GetVillaNumberResult());
		ourLuxuryVillasAndChaletsPage.ClickOnVilla();
		detailsVillaPage.ClickOnInformationRequestBTN(Prenom,Nom,email,Phone);
	
		logger.info("End : I am inside test SearchVilla");

	}

}
