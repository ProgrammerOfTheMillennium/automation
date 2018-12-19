package io.test.automation.lesson5.elements

import com.codeborne.selenide.ElementsContainer
import com.codeborne.selenide.SelenideElement

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class Calculator extends ElementsContainer {
    //Геттеры для элементов
    private SelenideElement getButton(String name) {
        self.$x(".//button[.='$name']")
    }

    private SelenideElement getResultsElement() {
        self.$(".calculator-display__result")
    }

    //Публичные методы
    void clickButton(String button) {
        getButton(button).click()
    }

    String getResult() {
        resultsElement.text
    }
}
