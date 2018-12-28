package io.test.automation

import com.codeborne.selenide.logevents.SelenideLogger
import groovy.util.logging.Slf4j
import io.test.automation.lesson5.steps.SearchSteps
import io.test.automation.lesson8.TabManager
import io.test.automation.lesson9.LogListener
import org.junit.Before
import org.junit.Test

/**
 * Created on 11.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */
@Slf4j
class LessonNine {

    @Before
    void setUp() {
        SelenideLogger.addListener("LogListener", new LogListener())
    }

    @Test
    void loggingTestB() {
        log.info("INFO")
        log.error("ERROR")
        log.warn("WARN")
        log.debug("DEBUG")
        log.trace("TRACE")
    }

    @Test
    void loggingTest() {
        TabManager.cleanUp()

        SearchSteps.searchFor("1")
        TabManager.init()

        for (int i = 2; i <= 5 ; i++) {
            def searchRequest = "$i"
            TabManager.newTab(searchRequest)
            SearchSteps.searchFor(searchRequest)
        }

        TabManager.closeAndSwitch("2", "3")
        TabManager.closeAndSwitch("3", "MAIN")

        TabManager.cleanUp()
    }
}
