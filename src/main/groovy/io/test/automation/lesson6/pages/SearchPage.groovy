package io.test.automation.lesson6.pages

import com.codeborne.selenide.SelenideElement

import static com.codeborne.selenide.Selenide.$

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class SearchPage {

    static SelenideElement getSearchField() {
        return $("#text")
    }

    static getSearchButton() {
        $(".search2__button")
    }

}
