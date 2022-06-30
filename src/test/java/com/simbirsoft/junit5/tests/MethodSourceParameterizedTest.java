package com.simbirsoft.junit5.tests;

import com.codeborne.selenide.Selenide;
import com.simbirsoft.junit5.pages.GoogleSearchPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class MethodSourceParameterizedTest extends TestBase {

    private GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    static Stream<Arguments> checkSearchElements() {
        return Stream.of(
                Arguments.of(
                        "selenide", List.of("Selenide: лаконичные и стабильные UI тесты на Java", "Selenide - Concise UI Tests with Java! - GitHub", "Selenide User Guide")
                ),
                Arguments.of(
                        "qa.guru", List.of("QA.Guru", "QA GURU - YouTube", "QA.GURU - GitHub")
                )
        );
    }

    @MethodSource("checkSearchElements")
    @ParameterizedTest
    void checkSearchElements(String searchQuery, List<String> resultFragments) {
        Selenide.open("");
        googleSearchPage.doSearch(searchQuery).checkPresenceOfListOfResults(resultFragments);
    }
}
