package io.test.automation

import com.codeborne.selenide.logevents.SelenideLogger
import io.test.automation.lesson9.LogListener
import org.testng.annotations.BeforeMethod

/**
 * Created on 28.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

abstract class BaseTest {
    private static boolean isTestsStarted = false

    @BeforeMethod
    void setUp() {
        if (!isTestsStarted) {
            isTestsStarted = true
            //вызываем методы, которые должны выполниться 1 раз
            SelenideLogger.addListener("LogListener", new LogListener())
        }
    }
}
