package com.qa.pages;

import com.qa.common.CommonAction;
import com.qa.common.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class AzureVideoInsightsPage extends JavaScriptExecutor {

    public WebDriver driver;
    // Locators
    private final By VideoPlayButtonLocator = By.xpath("/html/body/app-root/div/div[2]/app-media/section/div[1]/app-embed-player/div/app-vi-player/div/div[2]/div/div/div[7]/div[1]/button");
    private final By VideoBarLengthLocator = By.xpath("//*[@id='iframeEmbedPlayer']/div/div[7]/div[2]/div[1]/div/div[4]");
    private final By VideoBarWidthLocator = By.xpath("//*[@id='iframeEmbedPlayer']/div/div[7]/div[2]/div[1]/div/div[3]");
    private final By PersonSectionLocator = By.xpath("//*[@id='facesComponent']/div[1]/app-vi-insights-widget-header/div/div[1]/h2/span[1]");
    private final By TopicSectionLocator = By.xpath("/html/body/app-root/div/div[2]/app-media/section/div[2]/app-vi-insights/section/div[2]/div/div/app-vi-insights-topics/section/div[1]/div/app-vi-insights-widget-header/div/div[1]/h2/span[1]");
    private final By AudioEffectSectionLocator = By.xpath("//*[@id='acousticEventsComponent']/div[1]/div/app-vi-insights-widget-header/div/div[1]/h2/span[1]");
    private final By KeywordsSectionLocator = By.xpath("//*[@id='keywordsComponent']/div[1]/div/app-vi-insights-widget-header/div/div[1]/h2/span[1]");
    private final By LabelSectionLocator = By.xpath("//*[@id='labelsComponent']/div[1]/div/app-vi-insights-widget-header/div/div[1]/h2/span[1]");
    private final By NamedEntitiesSectionLocator = By.xpath("//*[@id='mentionedEntitiesComponent']/div[1]/div/app-vi-insights-widget-header/div/div[1]/h2/span[1]");

    private final By PersonSectionTimeLineLocator = By.xpath("//*[@id='facesComponent']/div[4]/div/app-vi-insights-horizontal-timeline/div[1]");
    private final By TopicSectionTimeLineLocator = By.xpath("/html/body/app-root/div/div[2]/app-media/section/div[2]/app-vi-insights/section/div[2]/div/div/app-vi-insights-topics/section/div[2]/div/div/app-vi-insights-horizontal-timeline/div[1]");
    private final By AudioEffectSectionTimeLineLocator = By.xpath("//*[@id='acousticEventsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]");
    private final By KeywordsSectionTimeLineLocator = By.xpath("//*[@id='keywordsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]");
    private final By LabelSectionTimeLineLocator = By.xpath("//*[@id='labelsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]");
    private final By NamedEntitiesSectionTimeLineLocator = By.xpath("//*[@id='mentionedEntitiesComponent']/div[4]/div/app-vi-insights-horizontal-timeline/div[1]");

    private final By PersonSectionNextButtonLocator = By.xpath("//*[@id='facesComponent']/div[4]/div/app-vi-insights-horizontal-timeline/div[2]/a[2]");
    private final By TopicSectionNextButtonLocator = By.xpath("/html/body/app-root/div/div[2]/app-media/section/div[2]/app-vi-insights/section/div[2]/div/div/app-vi-insights-topics/section/div[2]/div/div/app-vi-insights-horizontal-timeline/div[2]/a[2]");
    private final By AudiEffectSectionNextButtonLocator = By.xpath("//*[@id='acousticEventsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[2]/a[2]");
    private final By KeyWordsSectionNextButtonLocator = By.xpath("//*[@id='keywordsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[2]/a[2]");
    private final By LabelSectionNextButtonLocator = By.xpath("//*[@id='labelsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[2]/a[2]");
    private final By NamedEntitiesSectionNextButtonLocator = By.xpath("//*[@id='mentionedEntitiesComponent']/div[4]/div/app-vi-insights-horizontal-timeline/div[2]/a[2]");

    private final By TimeLineButtonLocator = By.id("tab1");
    private final By TimeLineTextLine1Locator = By.id("timelineScript1");
    private final By TimeLineTextLine2Locator = By.id("timelineScript2");

    private final By DownloadInsightsDownArrowButtonLocator = By.id("download-insights");
    private final By DownloadListsLocator = By.xpath("//*[@id='submenu-download-insights']/li");
    private final By ZipDownloadButtonLocator = By.xpath("//*[@id='submenu-download-insights']/li[2]/label/span");

    List<String> value = new ArrayList<String>();

    public AzureVideoInsightsPage(WebDriver driver) {
        this.driver = driver;}

    public void MovieVideoToEnding() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(VideoPlayButtonLocator);
        Thread.sleep(10000);
        action.moveToElement(we).moveToElement(driver.findElement(VideoPlayButtonLocator)).click().build().perform();
        WebElement Length = driver.findElement(VideoBarLengthLocator);
        DrawBarLength(Length);
        WebElement Width = driver.findElement(VideoBarWidthLocator);
        DrawBarWidth(Width);
    }
    public void ClickPlayButton(){
        CommonAction.ClickAction(VideoPlayButtonLocator);
    }

    public String PersonSectionTitle(){
        return CommonAction.ReturnText(PersonSectionLocator);
    }
    public String TopicSectionTitle(){
        return CommonAction.ReturnText(TopicSectionLocator);
    }
    public String AudioEffectSectionTitle(){
        return CommonAction.ReturnText(AudioEffectSectionLocator);
    }
    public String KeywordsSectionTitle(){
        return CommonAction.ReturnText(KeywordsSectionLocator);
    }
    public String LabelSectionTitle(){
        return CommonAction.ReturnText(LabelSectionLocator);
    }
    public String NamedEntitiesSectionTitle(){
        return CommonAction.ReturnText(NamedEntitiesSectionLocator);
    }
    public String PersonSectionTimeLineBar(){
        return CommonAction.ReturnAttribute(PersonSectionTimeLineLocator,"class");
    }
    public String TopicSectionTimeLineBar(){
        return CommonAction.ReturnAttribute(TopicSectionTimeLineLocator,"class");
    }
    public String AudioEffectSectionTimeLineBar(){
        return CommonAction.ReturnAttribute(AudioEffectSectionTimeLineLocator,"class");
    }
    public String KeywordsSectionTimeLineBar(){
        return CommonAction.ReturnAttribute(KeywordsSectionTimeLineLocator,"class");
    }
    public String LabelSectionTimeLineBar(){
        return CommonAction.ReturnAttribute(LabelSectionTimeLineLocator,"class");
    }
    public String NamedEntitiesSectionTimeLineBar(){
        return CommonAction.ReturnAttribute(NamedEntitiesSectionTimeLineLocator,"class");
    }
    public void ClickPersonSectionNextButton(){
        CommonAction.ClickAction(PersonSectionNextButtonLocator);
    }
    public void ClickTopicSectionNextButton(){
        CommonAction.ClickAction(TopicSectionNextButtonLocator);
    }  public void ClickAudiEffectSectionNextButton(){
        CommonAction.ClickAction(AudiEffectSectionNextButtonLocator);
    }  public void ClickKeyWordsSectionNextButton(){
        CommonAction.ClickAction(KeyWordsSectionNextButtonLocator);
    }  public void ClickLabelSectionNextButton(){
        CommonAction.ClickAction(LabelSectionNextButtonLocator);
    }  public void ClickNamedEntitiesSectionNextButton(){
        CommonAction.ClickAction(NamedEntitiesSectionNextButtonLocator);
    }
    public void ClickTimeLineButton(){
        CommonAction.ClickAction(TimeLineButtonLocator);
    }
    public String TimeLineTextLine1(){
        return CommonAction.ReturnText(TimeLineTextLine1Locator);
    }
    public String TimeLineTextLine2(){
        return CommonAction.ReturnText(TimeLineTextLine2Locator);
    }
    public void ClickDownloadInsightsDownArrowButton(){
        CommonAction.ClickAction(DownloadInsightsDownArrowButtonLocator);
    }
    public void ClickZipDownloadButton(){
        CommonAction.ClickAction(ZipDownloadButtonLocator);
    }
    public List<String> OptionDownloadInsights(){
        List<WebElement> RowsOfRadioButtons = driver.findElements(DownloadListsLocator);
        int RowsOfRadioButtonsCount = RowsOfRadioButtons.size();

        for (int i = 1; i <= RowsOfRadioButtonsCount; i++) {
            String DownloadButtonTypePath = "//*[@id='submenu-download-insights']/li["+i+"]/label/span";
            WebElement DownloadButtonType = driver.findElement(By.xpath(DownloadButtonTypePath));
            DownloadButtonType.getText();
            DrawBorder(DownloadButtonType);
            value.add(DownloadButtonType.getText());
        }
        return value;
    }
}
