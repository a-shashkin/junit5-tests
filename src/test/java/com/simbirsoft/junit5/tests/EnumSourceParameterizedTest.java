package com.simbirsoft.junit5.tests;

import com.codeborne.selenide.Selenide;
import com.simbirsoft.junit5.components.GoogleSearchPage;
import com.simbirsoft.junit5.domain.GoogleMenuItem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class EnumSourceParameterizedTest extends TestBase {

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @EnumSource(value = GoogleMenuItem.class, names = {"ALL", "VIDEO", "NEWS", "PICTURES"}, mode = EnumSource.Mode.INCLUDE)
    @ParameterizedTest
    void checkSearchElements(GoogleMenuItem menuItem) {
        Selenide.open("");
        if ((menuItem == GoogleMenuItem.ALL) || (menuItem == GoogleMenuItem.VIDEO)) {
            googleSearchPage.doSearch("qa.guru").switchToMenuItem(menuItem).checkPresenceOfResult(0, "QA.GURU");
        } else if (menuItem == GoogleMenuItem.NEWS) {
            googleSearchPage.doSearch("qa.guru").switchToMenuItem(menuItem).checkPresenceOfNews(0, "QA.GURU");
        } else if (menuItem == GoogleMenuItem.PICTURES) {
            googleSearchPage.doSearch("qa.guru").switchToMenuItem(menuItem).checkPresenceOfPics(0, "QA.GURU");
        }
    }
}
