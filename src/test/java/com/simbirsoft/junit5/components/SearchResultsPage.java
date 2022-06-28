package com.simbirsoft.junit5.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.simbirsoft.junit5.domain.GoogleMenuItem;

import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    private ElementsCollection searchResults = $$("h3.LC20lb");
    private ElementsCollection newsSearchResults = $$("div.mCBkyc");
    private ElementsCollection picsSearchResults = $$("span.OztcRd");

    public void checkPresenceOfResult(int resultIndex, String expectedResult) {
        searchResults.get(resultIndex).shouldHave(Condition.text(expectedResult));
    }

    public void checkPresenceOfNews(int resultIndex, String expectedResult) {
        newsSearchResults.get(resultIndex).shouldHave(Condition.text(expectedResult));
    }

    public void checkPresenceOfPics(int resultIndex, String expectedResult) {
        picsSearchResults.get(resultIndex).shouldHave(Condition.text(expectedResult));
    }

//    public void methodSearch(List<String> options) {
//        Iterator<String> iterator = options.iterator();
//        while (iterator.hasNext()) {
//            searchResults.shouldHave(CollectionCondition.textsInAnyOrder(options));
//        }
//    }

    public void checkPresenceOfListOfResults(List<String> options) {
        Iterator<String> iterator = options.iterator();
        while (iterator.hasNext()) {
            searchResults.shouldHave(CollectionCondition.itemWithText(iterator.next()));
        }

    }

    public SearchResultsPage switchToMenuItem(GoogleMenuItem googleMenuItem) {
        if (googleMenuItem == GoogleMenuItem.ALL) {
            $$("div.hdtb-mitem").find(Condition.text("Все")).click();
        } else if (googleMenuItem == GoogleMenuItem.VIDEO) {
            $$("div.hdtb-mitem").find(Condition.text("Видео")).click();
        } else if (googleMenuItem == GoogleMenuItem.NEWS) {
            $$("div.hdtb-mitem").find(Condition.text("Новости")).click();
        } else if (googleMenuItem == GoogleMenuItem.PICTURES) {
            $$("div.hdtb-mitem").find(Condition.text("Картинки")).click();
        } else if  (googleMenuItem == GoogleMenuItem.MAPS) {
            $$("div.hdtb-mitem").find(Condition.text("Карты")).click();
        } else if (googleMenuItem == GoogleMenuItem.MORE) {
            $$("div.hdtb-mitem").find(Condition.text("Ещё")).click();
        } else throw new IllegalArgumentException("The enum " + googleMenuItem + " does not exist.");
        return this;
    }
}
