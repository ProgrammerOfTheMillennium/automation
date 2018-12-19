package io.test.automation.lesson5.steps

import com.codeborne.selenide.Condition
import io.test.automation.lesson5.pages.SearchResults

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class CalculatorSteps {

    private static waitCalculator() {
        SearchResults.calculator.self.shouldBe(Condition.visible)
    }

    static String calculate(String expression) {
        waitCalculator()
        SearchResults.calculator.clickButton("C")
        expression.toList().each {
            switch (it) {
                case "(":
                    SearchResults.calculator.clickButton("( )")
                    break
                case ")":
                    SearchResults.calculator.clickButton("( )")
                    break
                case "-":
                    SearchResults.calculator.clickButton("−")
                    break
                case "*":
                    SearchResults.calculator.clickButton("×")
                    break
                case "/":
                    SearchResults.calculator.clickButton("÷")
                    break
                default:
                    SearchResults.calculator.clickButton(it)
                    break
            }
        }
        return SearchResults.calculator.result
    }

    static String getResult() {
        waitCalculator()
        SearchResults.calculator.result
    }
}
