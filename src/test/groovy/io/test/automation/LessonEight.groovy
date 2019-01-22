package io.test.automation

import io.test.automation.lesson5.steps.SearchSteps
import io.test.automation.lesson8.TabManager
import org.testng.annotations.Test

/**
 * Created on 11.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */
class LessonEight {

    @Test
    void windowsTest() {
        TabManager.cleanUp()

        SearchSteps.searchFor("1")
        TabManager.init()

        for (int i = 2; i <= 5; i++) {
            def searchRequest = "$i"
            TabManager.newTab(searchRequest)
            SearchSteps.searchFor(searchRequest)
        }

        TabManager.closeAndSwitch("2", "3")
        TabManager.closeAndSwitch("3", "MAIN")

        TabManager.cleanUp()
    }
}
