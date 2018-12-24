package io.test.automation.lesson5.pages

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Attachment
import io.qameta.allure.Step

import static com.codeborne.selenide.Selenide.$

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class SearchPage {

    @Step("Получаем поле ввода поиска")
    @Attachment
    static SelenideElement getSearchField() {
        return $("#text")
    }

    @Step("Получаем кнопку поиска")
    @Attachment
    static getSearchButton() {
        $(".search2__button")
    }

}
