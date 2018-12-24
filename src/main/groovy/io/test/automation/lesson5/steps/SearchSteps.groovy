package io.test.automation.lesson5.steps

import com.codeborne.selenide.Selenide
import io.qameta.allure.Step
import io.test.automation.lesson5.pages.SearchPage

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class SearchSteps {

    @Step("Открываем страницу поиска")
    private static openSearchPage() {
        Selenide.open("https://ya.ru/")
    }

    @Step("Выполняем поиск: {0}")
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
