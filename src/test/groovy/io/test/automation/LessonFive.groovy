package io.test.automation

import com.codeborne.selenide.logevents.SelenideLogger
import io.test.automation.lesson5.steps.CalculatorSteps
import io.test.automation.lesson5.steps.SearchSteps
import io.test.automation.lesson9.LogListener
import org.junit.Before
import org.junit.Test

/**
 * Created on 19.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class LessonFive extends BaseTest{

    @Test
    void pageObjectTest() {
        SearchSteps.searchFor("100/2=")
        assert CalculatorSteps.result == "50"
        assert CalculatorSteps.calculate("(1-3)*(3-7+6)-5/2=") == "−6,5"
        assert CalculatorSteps.calculate("1*2*3*4-1-2-3-4=") == "14"
    }
}
