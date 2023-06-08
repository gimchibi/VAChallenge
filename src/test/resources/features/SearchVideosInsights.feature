@SearchVideoInsights @VAChallenge
Feature: Search video indexer service

  As a User, I can search for videos containing any text, person, insights or object specified within the indexed videos visible to me.

  Background:
    Given I am on the VA Login page
    And I have entered a valid username and password of VA login page


  Scenario: Search a Video Insights
    Given I am on the Azure Video Indexer Main page
    Then The page displays a search box where a search GovTechRewind query can be entered
    And I filter my InsightType query Language and English
    And Clicking Search will perform the search GovTechRewind query and display relevant search results
    And The search query bar allows the filtering of search results by Scope of search
    And The search query bar allows the filtering of search results by Insight Type
    Then a search is performed, the page will display a listing of 3 GovTechRewind videos that have been indexed
    Then Hovering the cursor over each video tile will reveal video information
    Then User can toggle between a list view
    Then User can toggle between a tiled view




