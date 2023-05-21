@ViewVideoInsights
Feature:Upload video to video indexer service

  As a User, after uploading and creating an index for a video, I am able to click on the video to view video playback along with insights extracted.

  Background:
    Given I am on the VA Login page
    And I have entered a valid username and password of VA login page
    Given I am on the Azure Video Indexer Main page

  Scenario: View a Video Insights
    Given I am on the Azure Video Indexer Inside page
    Then The page contains a video player allowing playback of the current selected video
    And I playback current selected video
    Then The page contains an Insights section with the Insight details
    Then There is a timeline showing relevant segments in the video where the insight occurs in each insight topic
    And Clicking on an occurrence on the timeline will advance video player playback to the relevant moment in the video
    Then The page also contains a Timeline section, which displays the full transcribed text from the video
    Then There should be an option to download the completed insights in 3 formats

