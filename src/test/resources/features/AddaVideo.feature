@AddAVideo @VAChallenge
Feature: Upload video to video indexer service

  As a User, I can upload video to the video indexer service to derive relevant video insights.

  Background:
    Given I am on the VA Login page
    And I have entered a valid username and password of VA login page

  Scenario: Add a Video
    Given I am on the Azure Video Indexer Main page
    And I click on the Upload button
    Then The page allows the selection of a file for uploading or the user can supply a url to a video for indexing
    And I choose FileUpload option
    Then The video source language can be specific in Total: 66
    Then The page allows privacy to be set for the video insight
    Then An advanced options section should be able to to allow user to choose additional options for uploading FileUpload
    And Clicking the upload button will start the indexing process
    Then A notification is received when indexing has completed and the video will be visible in your Library
