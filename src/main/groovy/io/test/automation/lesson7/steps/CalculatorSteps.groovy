package io.test.automation.lesson7.steps

import com.codeborne.selenide.Condition
import io.test.automation.lesson7.pages.SearchResultsPage

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

    static String getResult() {
        waitCalculator()
        SearchResultsPage.calculator.result
    }
}
