package io.test.automation.lesson5.pages

import static com.codeborne.selenide.Selenide.$

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class SearchPage {

    static getSearchField() {
        $("#text")
    }

    static getSearchButton() {
        $(".search2__button")
    }

}
