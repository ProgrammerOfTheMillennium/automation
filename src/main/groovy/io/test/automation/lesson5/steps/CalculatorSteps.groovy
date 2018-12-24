package io.test.automation.lesson5.steps

import com.codeborne.selenide.Condition
import io.qameta.allure.Attachment
import io.qameta.allure.Step
import io.test.automation.lesson5.pages.SearchResultsPage

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class CalculatorSteps {

    private static waitCalculator() {
        SearchResultsPage.calculator.self.shouldBe(Condition.visible)
    }

    @Step("Подсчитываем результат: {0}")
    @Attachment
    static String calculate(String expression) {
        waitCalculator()
        SearchResultsPage.calculator.clickButton("C")
        expression.toList().each {
            switch (it) {
                case "(":
                    SearchResultsPage.calculator.clickButton("( )")
                    break
                case ")":
                    SearchResultsPage.calculator.clickButton("( )")
                    break
                case "-":
                    SearchResultsPage.calculator.clickButton("−")
                    break
                case "*":
                    SearchResultsPage.calculator.clickButton("×")
                    break
                case "/":
                    SearchResultsPage.calculator.clickButton("÷")
                    break
                default:
                    SearchResultsPage.calculator.clickButton(it)
                    break
            }
        }
        return SearchResultsPage.calculator.result
    }

    @Step("Возвращаем результат")
    @Attachment
    static String getResult() {
        waitCalculator()
        SearchResultsPage.calculator.result
    }
}
