package com.simbirsoft.junit5.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.simbirsoft.junit5.components.GoogleSearchPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;

public class CsvSourceParameterizedTest extends TestBase {

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @CsvSource(value = {
            "selenide, 0, Selenide",
            "qa.guru, 0, QA.Guru"
    })
    @ParameterizedTest
    void searchInGoogleTest(String searchQuery, int resultIndex, String expectedResult) {
        Selenide.open("");
        googleSearchPage.doSearch(searchQuery).checkPresenceOfResult(resultIndex, expectedResult);
    }
}
