package com.qa.pages;

import com.qa.common.CommonAction;
import com.qa.common.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AzureVideoIndexUploadPage extends JavaScriptExecutor {

    public WebDriver driver;
    // Locators
    private final By VideoUploadButtonLocator = By.id("galleryUploadtabs");
    private final By VideoBrowseForFilesButtonLocator = By.id("browseForFileAction");
    private final By VideoEnterURLButtonLocator = By.id("enterUrlAction");
    private final By VideoEnterURLFileNameLocator = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-vi-dialog/div/div[2]/vi-upload-dialog/div[2]/vi-indexing-form/div/div/main[1]/vi-indexing-settings-general/div/div/div[1]/div/div/vi-ui-input/div/input");
    private final By VideoAddURLButtonLocator = By.id("addURLButton");
    private final By CheckMyMediaFileLocator = By.xpath("//*[@id='containerId']/vi-ui-tag/div/span");
    private final By CountsOfVideoSourceLanguageLocator = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-vi-dialog/div/div[2]/vi-upload-dialog/div[2]/vi-indexing-form/div/div/main[1]/vi-indexing-settings-general/div/div/div[4]/vi-indexing-language/div/app-vi-fluent-action-menu/div/p-dropdown/div/div[4]/div/ul/p-dropdownitem");
    private final By VideoSourceLanguageArrowButtonListLocator = By.xpath("//*[@id='indexingLanguage']/p-dropdown/div/div[2]/span/i");
    private final By LanguageSelectedLocator = By.xpath("//*[@id='indexingLanguage']/p-dropdown/div/div[2]/span/span");
    private final By PrivacyArrowButtonListLocator = By.xpath("//*[@id='indexingPrivacy']/p-dropdown/div/div[2]/span/i");
    private final By PrivacyListPrivateLocator = By.xpath("//*[@id='PRIVATE']/span");
    private final By PrivacyListPUBLICLocator = By.xpath("//*[@id='PUBLIC']/span");
    private final By PrivacySelectedLocator = By.xpath("//*[@id='indexingPrivacy']/p-dropdown/div/div[2]/span/span");
    private final By AdvanceSettingButtonLocator = By.xpath("//*[@id='advancedSettingsButton']/span");
    private final By RowsAdvanceSettingOptionsLocator = By.xpath("//*[@id='mat-dialog-0']/app-vi-dialog/div/div[2]/vi-upload-dialog/div[2]/vi-indexing-form/div/div/aside/vi-ui-nav-bar/ul/li");

    private final By VideoFileUploadFileNameLocator = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-vi-dialog/div/div[2]/vi-upload-dialog/div[2]/vi-indexing-form/div/div/main[1]/vi-indexing-settings-general/div/div/div[1]/div/vi-indexing-file-name-input/vi-ui-input/div/input");

    private final By UploadVideoFileCheckBoxLocator = By.xpath("//*[@id='mat-dialog-0']/app-vi-dialog/div/div[2]/vi-upload-dialog/footer/vi-upload-consent/vi-checkbox-with-label/div/label/span");
    private final By UploadVideoFileButtonLocator = By.id("uploadButtonAction");
    private final By UploadCloseButtonLocator = By.id("close");
    private final By WaitForNotificationLocator = By.xpath("//*[@id='notificationsBtn']/div");

    private final By CheckNotificationSuccessLocator = By.xpath("//*[@id='messagesList']/li[1]/vi-notification-card/div/div[1]/span[1]");
    private final By VideoVisibleLibraryLocator = By.xpath("/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[2]/vi-gallery-list-container/div/vi-gallery-grid-view/cdk-virtual-scroll-viewport/div[1]/div/div[1]/vi-gallery-grid-item/a/div[2]/div/span[1]/span");

    List<String> value = new ArrayList<String>();

    public AzureVideoIndexUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ClickUploadButton() {
        CommonAction.ClickAction(VideoUploadButtonLocator);
    }

    public String BrowseForFileButtonTitle() {
        WebElement Title = driver.findElement(VideoBrowseForFilesButtonLocator);
        DrawBorder(Title);
        return driver.findElement(VideoBrowseForFilesButtonLocator).getAttribute("title");
    }

    public String EnterUrlButtonTitle() {
        WebElement Title = driver.findElement(VideoEnterURLButtonLocator);
        DrawBorder(Title);
        return driver.findElement(VideoEnterURLButtonLocator).getAttribute("title");
    }

    public void ClickEnterURLButton() {
        CommonAction.ClickAction(VideoEnterURLButtonLocator);
    }

    public void EnterFileURLName(String URLLocation) {
        CommonAction.TypeAction(VideoEnterURLFileNameLocator, URLLocation);
    }

    public void EnterFileUploadName(String URLLocation) {
        CommonAction.TypeAction(VideoFileUploadFileNameLocator, URLLocation);
    }

    public void ClickAddFileURLButton() {
        CommonAction.ClickAction(VideoAddURLButtonLocator);
    }

    public String CheckMyMediaFile() {
        return CommonAction.ReturnText(CheckMyMediaFileLocator);
    }

    public void uploadFile(String VideoFileName) {
        // disable the click event on an `<input>` file
        ((JavascriptExecutor) driver).executeScript(
                "HTMLInputElement.prototype.click = function() {                     " +
                        "  if(this.type !== 'file') HTMLElement.prototype.click.call(this);  " +
                        "};                                                                  ");
        // trigger the upload
        driver.findElement(VideoBrowseForFilesButtonLocator)
                .click();
        // assign the file to the `<input>`
        driver.findElement(By.cssSelector("input[type=file]"))
                .sendKeys(VideoFileName);
    }

    public void ClickVideoSourceLanguageArrowButton() {
        CommonAction.ClickAction(VideoSourceLanguageArrowButtonListLocator);
    }

    public int CheckVideoSourceLanguage() {
        List<WebElement> TotalVideoSourceLanguage = driver.findElements(CountsOfVideoSourceLanguageLocator);
        int TotalVideoSourceLanguageCount = TotalVideoSourceLanguage.size();
        System.out.println("the number of Langauges" + TotalVideoSourceLanguageCount);
        return TotalVideoSourceLanguageCount;
    }

    public String MySelectedLanguage() {
        return CommonAction.ReturnText(LanguageSelectedLocator);
    }

    public void ClickPrivacyArrowButton() {
        CommonAction.ClickAction(PrivacyArrowButtonListLocator);
    }

    public String PrivacySettingsPrivateLocator() {
        return CommonAction.ReturnText(PrivacyListPrivateLocator);
    }

    public String PrivacySettingsPublicLocator() {
        return CommonAction.ReturnText(PrivacyListPUBLICLocator);
    }

    public void ClickAdvanceSettingButton() {
        CommonAction.ClickAction(AdvanceSettingButtonLocator);
    }
    public String SelectedAdvancedValue(){
        return CommonAction.ReturnText(PrivacySelectedLocator);
    }

    public List<String> CheckAdvanceOptions(String Choice) {
        List<WebElement> TotalAdvanceSettingOptions = driver.findElements(RowsAdvanceSettingOptionsLocator);
        int TotalAdvanceSettingOptionsCount = TotalAdvanceSettingOptions.size() - 1;
        System.out.println("counts " + TotalAdvanceSettingOptionsCount);
        int intcount = 0;
        if (Choice.equalsIgnoreCase("FileUpload")) {
            intcount = 4;
            String AdvanceOptionsPath = "//*[@id='mat-dialog-0']/app-vi-dialog/div/div[2]/vi-upload-dialog/div[2]/vi-indexing-form/div/div/aside/vi-ui-nav-bar/ul/li[1]/span";
            WebElement AdvanceOptions = driver.findElement(By.xpath(AdvanceOptionsPath));
            value.add(AdvanceOptions.getText());
            DrawBorder(AdvanceOptions);
            value.add("Blank to skip filenames category");
        }else if (Choice.equalsIgnoreCase("EnterFileURL"))
             intcount = 1;
        for (int i = intcount; i <= TotalAdvanceSettingOptionsCount; i += 2) {
                String AdvanceOptionsPath = "//*[@id='mat-dialog-0']/app-vi-dialog/div/div[2]/vi-upload-dialog/div[2]/vi-indexing-form/div/div/aside/vi-ui-nav-bar/ul/li[" + i + "]/span";
                WebElement AdvanceOptions = driver.findElement(By.xpath(AdvanceOptionsPath));
                value.add(AdvanceOptions.getText());
                AdvanceOptions.click();
                DrawBorder(AdvanceOptions);
            }
        return value;
    }
    public void ClickUploadVideoFileCheckBox(){
        CommonAction.ClickAction(UploadVideoFileCheckBoxLocator);
    }
    public void ClickUploadVideoFileButton(){
        CommonAction.ClickAction(UploadVideoFileButtonLocator);
    }
    public void ClickUploadCloseButton(){
        CommonAction.ClickAction(UploadCloseButtonLocator);
    }
    public String waitfornotification(){
        return CommonAction.waitforNotification(WaitForNotificationLocator);
    }

    public void ClickNotification() {
        CommonAction.ClickAction(WaitForNotificationLocator);
    }
    public String CheckNotificationSuccess(){
        return CommonAction.ReturnText(CheckNotificationSuccessLocator);
    }
    public String VideoVisibleLibrary(){
        return CommonAction.ReturnText(VideoVisibleLibraryLocator);
    }
    public void ClickVideoWidget(){
        CommonAction.ClickAction(VideoVisibleLibraryLocator);
    }

}
