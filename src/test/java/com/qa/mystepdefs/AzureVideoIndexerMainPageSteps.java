package com.qa.mystepdefs;

import com.qa.common.WebDriverFactoryStaticThreadLocal;
import com.qa.Utils.TestProperites;
import com.qa.pages.AzureVideoIndexerMainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class AzureVideoIndexerMainPageSteps {

    private AzureVideoIndexerMainPage AzureVideoIndexerMainPage;

    @Given("I am on the Azure Video Indexer Main page")
    public void i_am_on_the_VA_Main() throws IOException, InterruptedException {
        AzureVideoIndexerMainPage = new AzureVideoIndexerMainPage(WebDriverFactoryStaticThreadLocal.getdriver());
        Thread.sleep(5000);
        Assert.assertEquals(AzureVideoIndexerMainPage.GetPageTitle(), TestProperites.loginprop().getProperty("AzureMainPageTitle"));
    }

    @Then("The page displays a search box where a search {} query can be entered")
    public void AC1SearchQueryBoxCanEntered(String FileName) {
        AzureVideoIndexerMainPage = new AzureVideoIndexerMainPage(WebDriverFactoryStaticThreadLocal.getdriver());
        AzureVideoIndexerMainPage.TypeSearchBoxTextArea(FileName);
        AzureVideoIndexerMainPage.ClickSearchFilterRightArrow();
    }

    @And("Clicking Search will perform the search {} query and display relevant search results")
    public void AC2SearchResults(String FileName) {
        AzureVideoIndexerMainPage.ClickSearchButton();
        Assert.assertTrue(AzureVideoIndexerMainPage.SearchQueryLabel().contains(FileName));
    }

    @And("The search query bar allows the filtering of search results by Scope of search")
    public void AC3FilterSearchType() {
        AzureVideoIndexerMainPage.ClickSearchFilterButton();
        AzureVideoIndexerMainPage.ClickSearchInDownArrowButton();
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchInTotalCount().get(0), "Entire video");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchInTotalCount().get(1), "On-screen text only");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchInTotalCount().get(2), "Transcript only");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchInTotalCount().get(3), "Labels only");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchInTotalCount().get(4), "Named locations only");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchInTotalCount().get(5), "Named people only");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchInTotalCount().get(6), "Brands only");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchInTotalCount().get(7), "Topics only");
    }

    @And("The search query bar allows the filtering of search results by Insight Type")
    public void AC3FilterSearchInsightType() {
        AzureVideoIndexerMainPage.ClickSearchInDownArrowButton();
        AzureVideoIndexerMainPage.ClickSearchInSightArrowButton();
        System.out.println(AzureVideoIndexerMainPage.SearchInsightsTotalCount());
    }

    @Then("a search is performed, the page will display a listing of {} {} videos that have been indexed")
    public void AC4DisplayListSearchVideo(int TotalVideos, String FileName) throws InterruptedException {
        AzureVideoIndexerMainPage.ClickSearchButton();
        Thread.sleep(2000);
        Assert.assertEquals(AzureVideoIndexerMainPage.TotalVideosCountIndexed(), TotalVideos);
        for (int i = 0; i <= TotalVideos - 1; i++) {
            Assert.assertEquals(AzureVideoIndexerMainPage.TotalVideosIndexed().get(i), FileName);
        }
    }

    @Then("Hovering the cursor over each video tile will reveal video information")
    public void AC5HoverVideoDetails() throws InterruptedException {
        AzureVideoIndexerMainPage.ClickSearchClearFilterCrossButton();
        for (int i = 0; i <= AzureVideoIndexerMainPage.NumberOfVideosTile()*2-2; i += 2) {
               Assert.assertTrue(AzureVideoIndexerMainPage.MouseHoverEachVideoTile().get(i).contains("Last modified"));
        }
        for (int k =1 ; k <= AzureVideoIndexerMainPage.NumberOfVideosTile()*2-1; k+= 2) {
               Assert.assertTrue(AzureVideoIndexerMainPage.MouseHoverEachVideoTile().get(k).contains(":"));
        }
    }
    @Then("User can toggle between a tiled view")
    public void AC6ToggleTiledViews() {
        AzureVideoIndexerMainPage.ClickSearchTileArrowButton();
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchTilesViewIconText(),"Tiles");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchListViewIconText(),"List");
        AzureVideoIndexerMainPage.ClickSearchTilesViewIcon();
        for (int i = 0; i <= AzureVideoIndexerMainPage.NumberOfVideosTile()-1; i++) {
            Assert.assertTrue(AzureVideoIndexerMainPage.TileUploadedBy().get(i).contains("Uploaded by"));
        }
    }
    @Then("User can toggle between a list view")
    public void AC6ToggleListViews()   {
        AzureVideoIndexerMainPage.ClickSearchTileArrowButton();
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchTilesViewIconText(),"Tiles");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchListViewIconText(),"List");
        AzureVideoIndexerMainPage.ClickSearchListViewIcon();
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchListViewNameTitle(),"Name");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchListViewIndexedByTitle(),"Indexed by");
        Assert.assertEquals(AzureVideoIndexerMainPage.SearchListViewLastModifiedTitle(),"Last modified");
    }
}
