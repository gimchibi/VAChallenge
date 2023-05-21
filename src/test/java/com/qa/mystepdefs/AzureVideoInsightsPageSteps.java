package com.qa.mystepdefs;

import com.qa.common.CommonDriver;
import com.qa.Utils.TestProperites;
import com.qa.pages.AzureVideoInsightsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class AzureVideoInsightsPageSteps {

    private AzureVideoInsightsPage AzureVideoInsightsPage;

    @Then("The page contains a video player allowing playback of the current selected video")
    public void AC1MoveVideotoEnding() throws InterruptedException {
        AzureVideoInsightsPage = new AzureVideoInsightsPage(CommonDriver.getdriver());
        AzureVideoInsightsPage.MovieVideoToEnding();
    }
    @And("I playback current selected video")
    public void AC1PlaybackVideo(){
        AzureVideoInsightsPage.ClickPlayButton();
    }
    @Then("The page contains an Insights section with the Insight details")
    public void AC2InsightDetails(){
        Assert.assertTrue(AzureVideoInsightsPage.PersonSectionTitle().contains("person"));
        Assert.assertTrue(AzureVideoInsightsPage.TopicSectionTitle().contains("topics"));
        Assert.assertTrue(AzureVideoInsightsPage.AudioEffectSectionTitle().contains("audio effect"));
        Assert.assertTrue(AzureVideoInsightsPage.KeywordsSectionTitle().contains("keywords"));
        Assert.assertTrue(AzureVideoInsightsPage.LabelSectionTitle().contains("labels"));
        Assert.assertTrue(AzureVideoInsightsPage.NamedEntitiesSectionTitle().contains("named entities"));
    }
    @Then("There is a timeline showing relevant segments in the video where the insight occurs in each insight topic")
    public void AC3TimelineSegments(){
        Assert.assertEquals(AzureVideoInsightsPage.PersonSectionTimeLineBar(),"horizontal-timeline");
        Assert.assertEquals(AzureVideoInsightsPage.TopicSectionTimeLineBar(),"horizontal-timeline");
        Assert.assertEquals(AzureVideoInsightsPage.AudioEffectSectionTimeLineBar(),"horizontal-timeline");
        Assert.assertEquals(AzureVideoInsightsPage.KeywordsSectionTimeLineBar(),"horizontal-timeline");
        Assert.assertEquals(AzureVideoInsightsPage.LabelSectionTimeLineBar(),"horizontal-timeline");
        Assert.assertEquals(AzureVideoInsightsPage.NamedEntitiesSectionTimeLineBar(),"horizontal-timeline");
    }
    @Then("Clicking on an occurrence on the timeline will advance video player playback to the relevant moment in the video")
    public void AC4ClickOnTimeLineSection(){
        AzureVideoInsightsPage.ClickPersonSectionNextButton();
        AzureVideoInsightsPage.ClickTopicSectionNextButton();
        AzureVideoInsightsPage.ClickAudiEffectSectionNextButton();
        AzureVideoInsightsPage.ClickKeyWordsSectionNextButton();
        AzureVideoInsightsPage.ClickLabelSectionNextButton();
        AzureVideoInsightsPage.ClickNamedEntitiesSectionNextButton();
    }
    @Then("The page also contains a Timeline section, which displays the full transcribed text from the video")
    public void AC5TimeLineFullDescription(){
        AzureVideoInsightsPage.ClickTimeLineButton();
        Assert.assertEquals(AzureVideoInsightsPage.TimeLineTextLine1(),"I'm.");
        Assert.assertEquals(AzureVideoInsightsPage.TimeLineTextLine2(),"A.");
    }
    @Then("There should be an option to download the completed insights in 3 formats")
    public void OptionDownloadTypeinsights() throws InterruptedException, IOException {
        TestProperites.DeleteExistingFunction(TestProperites.DownloadFilePath(TestProperites.loginprop().getProperty("AzureVideoFileName")),".zip");
        AzureVideoInsightsPage.ClickDownloadInsightsDownArrowButton();
        AzureVideoInsightsPage.ClickZipDownloadButton();
        Thread.sleep(10000);
        System.out.println("what is "+TestProperites.DownloadFilePath(TestProperites.loginprop().getProperty("AzureVideoFileName")+".zip"));
        Assert.assertTrue(TestProperites.DownloadFilePath(TestProperites.loginprop().getProperty("AzureVideoFileName")+".zip").contains(TestProperites.loginprop().getProperty("AzureVideoFileName")));

        AzureVideoInsightsPage.ClickDownloadInsightsDownArrowButton();
        Assert.assertEquals(AzureVideoInsightsPage.OptionDownloadInsights().get(0),"Insights (JSON)");
        Assert.assertEquals(AzureVideoInsightsPage.OptionDownloadInsights().get(1),"Artifacts (ZIP)");
        Assert.assertEquals(AzureVideoInsightsPage.OptionDownloadInsights().get(2),"Source video");
        Assert.assertEquals(AzureVideoInsightsPage.OptionDownloadInsights().get(3),"Closed captions");
    }
}
