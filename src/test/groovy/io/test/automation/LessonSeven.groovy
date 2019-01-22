package io.test.automation

import io.qameta.allure.*
import io.test.automation.lesson5.steps.CalculatorSteps
import io.test.automation.lesson5.steps.SearchSteps
import org.testng.annotations.Test

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

@Epic("Тестовый эпик")
@Feature("Тестовая фича")
@Link("www.ya.ru")
@Issue("TICKET-1")
class LessonSeven {

    @Test
    @Description("Пример теста")
    @Severity(SeverityLevel.TRIVIAL)
    @TmsLink("TC-1")
    @Story("100/2=50")
    void allureTest() {
        SearchSteps.searchFor("100/2=")
        assert CalculatorSteps.result == "50"
    }

    @Test
    @Description("Пример теста 2")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("TC-2")
    @Story("12*2=24")
    void allureTestB() {
        SearchSteps.searchFor("12*2=")
        assert CalculatorSteps.result == "24"
    }

    @Test
    @Description("Пример теста 3")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("TC-3")
    @Story("1*2*3*4-1-2-3-4=14")
    void allureTestC() {
        SearchSteps.searchFor("2*2=")
        assert CalculatorSteps.result == "4"
        assert CalculatorSteps.calculate("1*2*3*4-1-2-3-4=") == "14"
    }
}
