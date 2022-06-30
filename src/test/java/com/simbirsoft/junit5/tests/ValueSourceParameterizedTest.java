package com.simbirsoft.junit5.tests;

import com.codeborne.selenide.Selenide;
import com.simbirsoft.junit5.pages.GoogleSearchPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValueSourceParameterizedTest extends TestBase {

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @ValueSource(strings = {
        "Selenide", "QA.GURU", "JUnit 5"
    })
    @ParameterizedTest
    void checkSearchResults(String searchQuery) {
        Selenide.open("");
        googleSearchPage.doSearch(searchQuery).checkPresenceOfResult(0, searchQuery);
    }
}
