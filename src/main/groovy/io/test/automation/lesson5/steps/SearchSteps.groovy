package io.test.automation.lesson5.steps

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
        Selenide.open("https://ya.ru/")
    }

    static searchFor(String searchRequest) {
        openSearchPage()
        SearchPage.searchField.value = searchRequest
        SearchPage.searchButton.click()
    }

}
