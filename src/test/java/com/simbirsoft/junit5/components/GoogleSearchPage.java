package com.simbirsoft.junit5.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GoogleSearchPage {

    private SelenideElement searchInput = $("input.gLFyf"),

            searchButton = $("input.gNO89b");

    public SearchResultsPage doSearch(String searchQuery) {
        searchInput.setValue(searchQuery);
        searchButton.click();
        return new SearchResultsPage();
    }
}
