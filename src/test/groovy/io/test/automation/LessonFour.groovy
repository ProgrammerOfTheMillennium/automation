package io.test.automation

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.junit.Test
import org.openqa.selenium.By

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$
import static com.codeborne.selenide.Selenide.$x

/**
 * Created on 14.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class LessonFour {
    @Test
    void calculatorTest() {
        openYandex()
        def searchRequest = "100/2="
        searchFor(searchRequest)

        def calculatorResult = $(".calculator-display__result")
        assert calculatorResult.text == "50"

        clickButton("C")
        clickButton("1")
        clickButton("0")
        clickButton("0")
        clickButton("−")
        clickButton("7")
        clickButton("9")
        clickButton("=")

        assert calculatorResult.text == "21"
    }

    static searchFor(String searchRequest) {
        def searchField = $("#text")
        searchField.value = searchRequest
        def searchButton = $(".search2__button")
        searchButton.click()
    }

    static openYandex() {
        Selenide.open("https://ya.ru/")
    }

    static getCalculator() {
        $(".calculator__wrapper")
    }

    static getCalculatorButton(String name) {
        calculator.$x(".//button[.='$name']")
    }

    static clickButton(String button) {
        getCalculatorButton(button).click()
    }
}
