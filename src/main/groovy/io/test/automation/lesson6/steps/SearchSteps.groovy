package io.test.automation.lesson6.steps

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import io.test.automation.lesson5.pages.SearchPage

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class SearchSteps {

    private static openSearchPage() {
        def desiredUrl = "https://ya.ru/"
        if(!WebDriverRunner.hasWebDriverStarted() || WebDriverRunner.url() != desiredUrl) {
            Selenide.open(desiredUrl)
        }
    }

    static searchFor(String searchRequest) {
        openSearchPage()
        SearchPage.searchField.value = searchRequest
        SearchPage.searchButton.click()
    }

    static getCurrentSearchRequest() {
        openSearchPage()
        return SearchPage.searchField.value
    }
}
