package io.test.automation.lesson7.pages

import io.test.automation.lesson7.elements.Calculator

import static com.codeborne.selenide.Selenide.$

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class SearchResultsPage {

    static Calculator getCalculator() {
        def instance = new Calculator()
        instance.self = $(".calculator__wrapper")
        return instance
    }
}
