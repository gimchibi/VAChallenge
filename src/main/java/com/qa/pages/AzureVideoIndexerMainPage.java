package com.qa.pages;

import com.qa.common.WebDriverFactoryStaticThreadLocal;
import com.qa.common.CommonAction;
import com.qa.common.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class AzureVideoIndexerMainPage extends JavaScriptExecutor{

    public WebDriver driver;
    private final By SearchBoxTextAreaLocator = By.id("viFilterSearchInput");
    private final By SearchFilterRightArrowLocator = By.xpath("//*[@id='filterGalleryButton']/i[2]");
    private final By InsightTypeArrowLocator = By.xpath("//*[@id='filterActions_1']/p-dropdown/div/div[2]/span/i");
    private final By InsightTypeLanguageArrowLocator = By.xpath("//*[@id='id_1_1_language']/p-dropdown/div/div[2]/span/i");
    private final By InSightTypeDropDownListLocator = By.xpath("/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[1]/section/div/div/vi-gallery-search-input/vi-gallery-search-input-common/div/vi-gallery-search-filters/div/div[2]/div[2]/app-filter-item/div/div[1]/app-vi-fluent-action-menu/div/p-dropdown/div/div[4]/div/ul/p-dropdownitem");
    private final By SearchButtonLocator = By.xpath("//*[@id='search']/span");
    private final By SearchQueryLabelLocator = By.xpath("//*[@id='gallerySearchForm']/div/vi-gallery-search-input/vi-gallery-search-input-common/div/div/div/div[1]/div/div/vi-filter-tags/div/div/div/span");
    private final By SearchFilterButtonLocator = By.id("filterGalleryButton");
    private final By SearchInDownArrowButtonLocator = By.xpath("//*[@id='scope-filter-id']/p-dropdown/div/div[2]/span/i");
    private final By SearchInDropDownListLocator = By.xpath("//*[@id='scope-filter-id']/p-dropdown/div/div[4]/div/ul/p-dropdownitem");
    private final By SearchInSightArrowButtonLocator = By.xpath("//*[@id='filterActions_2']/p-dropdown/div/div[2]/span/i");
    private final By SearchInSightDropDownListLocator = By.xpath("/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[1]/section/div/div/vi-gallery-search-input/vi-gallery-search-input-common/div/vi-gallery-search-filters/div/div[2]/div[2]/app-filter-item/div/div[1]/app-vi-fluent-action-menu/div/p-dropdown/div/div[4]/div/ul/p-dropdownitem");
    private final By SearchListOfVideosLocator = By.xpath("//*[@id='artifactContentList']/div[1]/div");
    private final By SearchClearFilterCrossButtonLocator = By.xpath("//*[@id='gallerySearchForm']/div/vi-gallery-search-input/vi-gallery-search-input-common/div/div/div/div[1]/div/div/div/i");
    private final By SearchNumberOfVideosLocator = By.xpath("/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[2]/vi-gallery-list-container/div/vi-gallery-grid-view/cdk-virtual-scroll-viewport/div[1]/div/div");
    private final By SearchTileArrowButtonLocator =By.xpath("//*[@id='gallery-view-menu']/p-dropdown/div/div[2]/span/i[2]");
    private final By SearchTilesViewIconLocator = By.xpath("//*[@id='grid-view']/span");
    private final By SearchListViewIconLocator = By.xpath("//*[@id='list-view']/span");
    private final By SearchListViewNameTitleLocator = By.xpath("/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[2]/vi-gallery-list-container/div/vi-gallery-list-view/div/div[1]/span[2]/span/div/div[1]/span");
    private final By SearchListViewIndexedByTitleLocator = By.xpath("/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[2]/vi-gallery-list-container/div/vi-gallery-list-view/div/div[1]/span[3]/span/div/div[1]/span");
    private final By SearchListViewLastModifiedTitleLocator = By.xpath("/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[2]/vi-gallery-list-container/div/vi-gallery-list-view/div/div[1]/span[4]/span/div/div[1]/span");


    public AzureVideoIndexerMainPage(WebDriver driver) {
        this.driver = driver;
    }

    List<String> value = new ArrayList<String>();
    List<String> value2 = new ArrayList<String>();
    List<String> value3 = new ArrayList<String>();
    List<String> value4 = new ArrayList<String>();
    List<String> value5 = new ArrayList<String>();

    public String GetPageTitle() {
        return WebDriverFactoryStaticThreadLocal.getdriver().getTitle();
    }

    public void TypeSearchBoxTextArea(String FileName) {
        CommonAction.TypeAction(SearchBoxTextAreaLocator, FileName);
    }

    public void ClickSearchFilterRightArrow() {
        CommonAction.ClickAction(SearchFilterRightArrowLocator);
    }

    public void ClickSearchButton() {
        CommonAction.ClickAction(SearchButtonLocator);
    }

    public String SearchQueryLabel() {
        return CommonAction.ReturnText(SearchQueryLabelLocator);
    }

    public void ClickSearchFilterButton() {
        CommonAction.ClickAction(SearchFilterButtonLocator);
    }

    public void ClickSearchInDownArrowButton() {
        CommonAction.ClickAction(SearchInDownArrowButtonLocator);
    }

    public List<String> SearchInTotalCount() {
        List<WebElement> SearchInDropDownList = driver.findElements(SearchInDropDownListLocator);
        int SearchInDropDownListCount = SearchInDropDownList.size();
        for (int i = 1; i <= SearchInDropDownListCount; i++) {
            String ButtonTypePath = "//*[@id='scope-filter-id']/p-dropdown/div/div[4]/div/ul/p-dropdownitem[" + i + "]/li/div";
            WebElement ButtonType = driver.findElement(By.xpath(ButtonTypePath));
            ButtonType.getText();
            DrawBorder(ButtonType);
            value.add(ButtonType.getText());
        }
        return value;
    }

    public void ClickSearchInSightArrowButton() {
        CommonAction.ClickAction(SearchInSightArrowButtonLocator);
    }
    public void ClickInSightTypeArrow(){
        CommonAction.ClickAction(InsightTypeArrowLocator);
    }
    public void ClickInSightType(String InSightType){
        List<WebElement> ClickInSightTypeDropDownList = driver.findElements(InSightTypeDropDownListLocator);
        int ClickInSightTypeDropDownListCount= ClickInSightTypeDropDownList.size();
        for (int i = 1; i <= ClickInSightTypeDropDownListCount; i++) {
            String DropDownPath = "/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[1]/section/div/div/vi-gallery-search-input/vi-gallery-search-input-common/div/vi-gallery-search-filters/div/div[2]/div[2]/app-filter-item/div/div[1]/app-vi-fluent-action-menu/div/p-dropdown/div/div[4]/div/ul/p-dropdownitem[" + i + "]/li/div/span";
            WebElement InsightTypeEle = driver.findElement(By.xpath(DropDownPath));
            if (InSightType.equalsIgnoreCase(InsightTypeEle.getText()))
                driver.findElement(By.xpath(DropDownPath)).click();
        }
    }
    public void ClickInsightTypeLanguageArrow(){
        CommonAction.ClickAction(InsightTypeLanguageArrowLocator);
    }
    public void SelectLanguageType(String InsightTypeValue){
        driver.findElement(By.xpath("//*[@id='"+InsightTypeValue+"']/span")).click();
    }

    public List<String> SearchInsightsTotalCount() {
        List<WebElement> SearchInDropDownList = driver.findElements(SearchInSightDropDownListLocator);
        int SearchInDropDownListCount = SearchInDropDownList.size();
        for (int i = 1; i <= SearchInDropDownListCount; i++) {
            String ButtonTypePath = "/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[1]/section/div/div/vi-gallery-search-input/vi-gallery-search-input-common/div/vi-gallery-search-filters/div/div[2]/div[2]/app-filter-item/div/div[1]/app-vi-fluent-action-menu/div/p-dropdown/div/div[4]/div/ul/p-dropdownitem[" + i + "]/li/div/span";
            WebElement ButtonType = driver.findElement(By.xpath(ButtonTypePath));
            ButtonType.getText();
            DrawBorder(ButtonType);
            value2.add(ButtonType.getText());
        }
        return value2;
    }
    public int TotalVideosCountIndexed() {
        List<WebElement> SearchListOfVideosList = driver.findElements(SearchListOfVideosLocator);
        return SearchListOfVideosList.size();
    }

    public List<String> TotalVideosIndexed() {
        List<WebElement> SearchListOfVideosList = driver.findElements(SearchListOfVideosLocator);
        int SearchListOfVideosListCount = SearchListOfVideosList.size();

        for (int i = 1; i <= SearchListOfVideosListCount; i++) {
            String ButtonTypePath = "//*[@id='artifactContentList']/div[1]/div[" + i + "]/vi-search-view-item/a/div[1]/div[2]/span[1]/div/vi-gallery-search-item/div/div/div/span";
            WebElement ButtonType = driver.findElement(By.xpath(ButtonTypePath));
            ButtonType.getText();
            DrawBorder(ButtonType);
            value3.add(ButtonType.getText());
        }
        return value3;
    }
    public void ClickSearchClearFilterCrossButton(){
        CommonAction.ClickAction(SearchClearFilterCrossButtonLocator);
    }
    public int NumberOfVideosTile(){
        List<WebElement> SearchNumberOfVideosList = driver.findElements(SearchNumberOfVideosLocator);
        return SearchNumberOfVideosList.size();
    }

    public List<String> MouseHoverEachVideoTile(){
        List<WebElement> SearchNumberOfVideosList = driver.findElements(SearchNumberOfVideosLocator);
        int SearchNumberOfVideosCount = SearchNumberOfVideosList.size();
        Actions action = new Actions(driver);

        for (int i = 1; i <= SearchNumberOfVideosCount; i++) {
            String VideoListPath = "/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[2]/vi-gallery-list-container/div/vi-gallery-grid-view/cdk-virtual-scroll-viewport/div[1]/div/div[" + i + "]/vi-gallery-grid-item/a/div[1]";
            WebElement VideoList = driver.findElement(By.xpath(VideoListPath));
            action.moveToElement(VideoList).moveToElement(driver.findElement(By.xpath(VideoListPath))).build().perform();
            for (int k = 1; k <= 2; k++) {
                String VideoTextPath = "/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[2]/vi-gallery-list-container/div/vi-gallery-grid-view/cdk-virtual-scroll-viewport/div[1]/div/div[" + i + "]/vi-gallery-grid-item/a/div[1]/figure/div//vi-item-figcaption/div/figcaption/span[" + k + "]";
                WebElement VideoText = driver.findElement(By.xpath(VideoTextPath));
                VideoText.getText();
                DrawBorder(VideoText);
                value4.add(VideoText.getText());
            }
        } return value4;
    }
    public void ClickSearchTileArrowButton(){
        CommonAction.ClickAction(SearchTileArrowButtonLocator);
    }

    public String SearchTilesViewIconText(){
        return CommonAction.ReturnText(SearchTilesViewIconLocator);
    }
    public String SearchListViewIconText(){
        return CommonAction.ReturnText(SearchListViewIconLocator);
    }
    public void ClickSearchListViewIcon(){
        CommonAction.ClickAction(SearchListViewIconLocator);
    }
    public void ClickSearchTilesViewIcon(){
        CommonAction.ClickAction(SearchTilesViewIconLocator);
    }
    public String SearchListViewNameTitle(){
        return CommonAction.ReturnText(SearchListViewNameTitleLocator);
    }
    public String SearchListViewIndexedByTitle(){
        return CommonAction.ReturnText(SearchListViewIndexedByTitleLocator);
    }
    public String SearchListViewLastModifiedTitle(){
        return CommonAction.ReturnText(SearchListViewLastModifiedTitleLocator);
    }
    public List<String> TileUploadedBy(){
        List<WebElement> SearchNumberOfVideosList = driver.findElements(SearchNumberOfVideosLocator);
        int SearchNumberOfVideosCount = SearchNumberOfVideosList.size();
        for (int i = 1; i <= SearchNumberOfVideosCount; i++) {
                String UploadByTextPath = "/html/body/app-root/div/div[2]/vi-gallery/vi-gallery-common/section/div[2]/vi-gallery-list-container/div/vi-gallery-grid-view/cdk-virtual-scroll-viewport/div[1]/div/div[" + i + "]/vi-gallery-grid-item/a/div[2]/div/span[2]";
                WebElement UploadByText = driver.findElement(By.xpath(UploadByTextPath));
                UploadByText.getText();
                DrawBorder(UploadByText);
                value5.add(UploadByText.getText());
        } return value5;
    }
}