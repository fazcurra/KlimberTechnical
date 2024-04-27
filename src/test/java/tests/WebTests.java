package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import tests.base.BaseTest;
import utils.Randomizer;

public class WebTests extends BaseTest {

    @Test
    public void verifyPricingInsuranceAndDataFillingTest() {
        PricingPage pricingPage = new PricingPage(driver);
        pricingPage.fillBirthDate("10102001");
        pricingPage.clickProvinceSelector();
        pricingPage.selectProvince();
        pricingPage.fillPhoneNumber("11", "12345678");
        pricingPage.moveSlider(50, 0);
        pricingPage.refreshClick();
        pricingPage.clickDisabilityCheckBox();
        pricingPage.clickAccidentCheckBox();
        pricingPage.clickIllnessCheckBox();
        pricingPage.clickFinalPrice();
        Assert.assertEquals(pricingPage.getMonthlyPrice(), "$ 848", "Monthly price is not as expected");
        PersonalInformationPage personalInformationPage = pricingPage.clickHireInsuranceButton();
        personalInformationPage.fillHeightInput("180");
        personalInformationPage.fillWeightInput("90");
        RegistrationPage registrationPage = personalInformationPage.clickNextButton();
        Assert.assertEquals(registrationPage.getTitle(), "Completá tus datos... Ya casi terminamos", "Title is not as expected");
        registrationPage.fillNameInput(Randomizer.getRandomString(5, true, false));
        registrationPage.fillSurnameInput(Randomizer.getRandomString(5, true, false));
        registrationPage.fillIdInput(Randomizer.getRandomString(8, false, true));
        registrationPage.clickSexSelector();
        registrationPage.selectMaleSex();
        registrationPage.clickGenderSelector();
        registrationPage.selectMaleGender();
        registrationPage.clickCivilStatusSelector();
        registrationPage.selectSingleCivilStatus();
        registrationPage.fillEmailInput(Randomizer.getRandomString(6, true, true) + "@gmail.com");
        registrationPage.fillPasswordInput(Randomizer.getRandomString(8, true, true));
        registrationPage.fillStreetInput(Randomizer.getRandomString(5, true, false));
        registrationPage.fillHouseNumberInput(Randomizer.getRandomString(3, false, true));
        registrationPage.fillZipCodeInput("1826");
        AdditionalInformationPage additionalInformationPage = registrationPage.clickNextButton();
        Assert.assertEquals(additionalInformationPage.getTitle(), "Necesito unos datos adicionales", "Title is not as expected");
        additionalInformationPage.clickNationalitySelector();
        additionalInformationPage.clickArgentinaOption();
        additionalInformationPage.fillPlaceOfBirthInput("Buenos Aires");
        additionalInformationPage.fillOccupationInput(Randomizer.getRandomString(5, true, false));
        additionalInformationPage.fillAnnualSalaryInput(Randomizer.getRandomString(6, false, true));
        additionalInformationPage.fillFullNameInput(Randomizer.getRandomString(5, true, false));
        additionalInformationPage.fillNumberIdInput(Randomizer.getRandomString(8, false, true));
        additionalInformationPage.clickAnnualIncomeSelector();
        additionalInformationPage.clickIncomeOption();
        PaymentPage paymentPage = additionalInformationPage.clickNextButton();
        Assert.assertEquals(paymentPage.getTitle(), "Por favor, ingresá los datos de tu medio de pago", "Title is not as expected");
        paymentPage.fillCardNumber("4548812049400004");
        BeneficiaryPage beneficiaryPage = paymentPage.clickNextButton();
        Assert.assertEquals(beneficiaryPage.getTitle(), "¿Querés elegir a tus beneficiarios ahora?", "Title is not as expected");
        SummaryPage summaryPage = beneficiaryPage.clickNextButton();
        Assert.assertEquals(summaryPage.getTitle(), "Este es el resumen de tu póliza.", "Title is not as expected");
        summaryPage.clickCheckBoxTermsAndConditions();
        CongratulationsPage congratulationsPage = summaryPage.clickNextButton();
        Assert.assertEquals(congratulationsPage.getTitle(), "¡Felicitaciones!", "Title is not as expected");
    }
}