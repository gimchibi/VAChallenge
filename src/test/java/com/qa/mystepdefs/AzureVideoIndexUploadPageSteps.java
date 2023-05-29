package com.qa.mystepdefs;

import com.qa.common.WebDriverFactoryStaticThreadLocal;
import com.qa.Utils.TestProperites;
import com.qa.pages.AzureVideoIndexUploadPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class AzureVideoIndexUploadPageSteps {

    private AzureVideoIndexUploadPage AzureVideoIndexUploadPage;


    @And("I click on the Upload button")
    public void ClickUploadButton(){
        AzureVideoIndexUploadPage = new AzureVideoIndexUploadPage(WebDriverFactoryStaticThreadLocal.getdriver());
        AzureVideoIndexUploadPage.ClickUploadButton();
    }
    @And("The page allows the selection of a file for uploading or the user can supply a url to a video for indexing")
    public void AC1AllowSelection() throws IOException {
        AzureVideoIndexUploadPage = new AzureVideoIndexUploadPage(WebDriverFactoryStaticThreadLocal.getdriver());
        Assert.assertEquals(AzureVideoIndexUploadPage.BrowseForFileButtonTitle(),TestProperites.loginprop().getProperty("AzureBrowseForFileTitle"));
        Assert.assertEquals(AzureVideoIndexUploadPage.EnterUrlButtonTitle(),TestProperites.loginprop().getProperty("AzureBrowseEnterURLTitle"));
    }
    @And("I choose {} option")
    public void ChoiceofUploadorEnterURL(String Choice) throws IOException, InterruptedException {
        AzureVideoIndexUploadPage = new AzureVideoIndexUploadPage(WebDriverFactoryStaticThreadLocal.getdriver());
        if (Choice.equalsIgnoreCase("FileUpload")) {
            AzureVideoIndexUploadPage.uploadFile(TestProperites.FilePath(TestProperites.loginprop().getProperty("AzureVideoFile")));
        } else if (Choice.equalsIgnoreCase("EnterFileURL")){
            AzureVideoIndexUploadPage.ClickEnterURLButton();
            AzureVideoIndexUploadPage.EnterFileURLName(TestProperites.loginprop().getProperty("MyFileURL"));
            AzureVideoIndexUploadPage.ClickAddFileURLButton();
            Assert.assertEquals(AzureVideoIndexUploadPage.CheckMyMediaFile(),"Media file 1");
        }
    }
    @Then("The video source language can be specific in Total: {int}")
    public void AC2VideoSourceLanguage(int TotalCount) {
        AzureVideoIndexUploadPage = new AzureVideoIndexUploadPage(WebDriverFactoryStaticThreadLocal.getdriver());
        AzureVideoIndexUploadPage.ClickVideoSourceLanguageArrowButton();
        Assert.assertEquals(AzureVideoIndexUploadPage.CheckVideoSourceLanguage(),TotalCount);
        AzureVideoIndexUploadPage.ClickVideoSourceLanguageArrowButton();
        Assert.assertEquals(AzureVideoIndexUploadPage.MySelectedLanguage(),"English");
    }
    @Then("The page allows privacy to be set for the video insight")
    public void AC3PrivacySetting(){
        AzureVideoIndexUploadPage = new AzureVideoIndexUploadPage(WebDriverFactoryStaticThreadLocal.getdriver());
        AzureVideoIndexUploadPage.ClickPrivacyArrowButton();
        Assert.assertEquals(AzureVideoIndexUploadPage.PrivacySettingsPrivateLocator(),"Private");
        Assert.assertEquals(AzureVideoIndexUploadPage.PrivacySettingsPublicLocator(),"Public");
        AzureVideoIndexUploadPage.ClickPrivacyArrowButton();
        Assert.assertEquals(AzureVideoIndexUploadPage.SelectedAdvancedValue(),"Private");
    }
    @Then("An advanced options section should be able to to allow user to choose additional options for uploading {}")
    public void AC4AdvanceOptions(String Choice) throws InterruptedException {
        AzureVideoIndexUploadPage = new AzureVideoIndexUploadPage(WebDriverFactoryStaticThreadLocal.getdriver());
        AzureVideoIndexUploadPage.ClickAdvanceSettingButton();
        Thread.sleep(2000);
        Assert.assertEquals(AzureVideoIndexUploadPage.CheckAdvanceOptions(Choice).get(0), "General settings");
        if (Choice.equalsIgnoreCase("EnterFileURL"))
        Assert.assertEquals(AzureVideoIndexUploadPage.CheckAdvanceOptions(Choice).get(1), "File names");

        Assert.assertEquals(AzureVideoIndexUploadPage.CheckAdvanceOptions(Choice).get(2), "Indexing presets");
        Assert.assertEquals(AzureVideoIndexUploadPage.CheckAdvanceOptions(Choice).get(3), "People models");
        Assert.assertEquals(AzureVideoIndexUploadPage.CheckAdvanceOptions(Choice).get(4), "Brand categories");
        Assert.assertEquals(AzureVideoIndexUploadPage.CheckAdvanceOptions(Choice).get(5), "File information");
    }
    @And("Clicking the upload button will start the indexing process")
    public void AC5ProceedUploadVideoFile(){
        AzureVideoIndexUploadPage = new AzureVideoIndexUploadPage(WebDriverFactoryStaticThreadLocal.getdriver());
        AzureVideoIndexUploadPage.ClickUploadVideoFileCheckBox();
        AzureVideoIndexUploadPage.ClickUploadVideoFileButton();
    }
    @Then("A notification is received when indexing has completed and the video will be visible in your Library")
    public void NotificationReceived() throws IOException {
        AzureVideoIndexUploadPage = new AzureVideoIndexUploadPage(WebDriverFactoryStaticThreadLocal.getdriver());
        AzureVideoIndexUploadPage.ClickUploadCloseButton();
        Assert.assertEquals(AzureVideoIndexUploadPage.waitfornotification(), "2");
        AzureVideoIndexUploadPage.ClickNotification();
        Assert.assertEquals(AzureVideoIndexUploadPage.CheckNotificationSuccess(), TestProperites.loginprop().getProperty("AzureVideoFileName") + " indexed");
        Assert.assertEquals(AzureVideoIndexUploadPage.VideoVisibleLibrary(), TestProperites.loginprop().getProperty("AzureVideoFileName"));
    }
    @Given("I am on the Azure Video Indexer Inside page")
    public void ClickOnVideoWidget(){
        AzureVideoIndexUploadPage = new AzureVideoIndexUploadPage(WebDriverFactoryStaticThreadLocal.getdriver());
        AzureVideoIndexUploadPage.ClickVideoWidget();
    }
}
