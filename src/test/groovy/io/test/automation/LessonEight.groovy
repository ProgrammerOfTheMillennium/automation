package io.test.automation

import io.test.automation.lesson5.steps.SearchSteps
import io.test.automation.lesson8.TabManager
import org.junit.Test

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
        //Работаем с первой вкладкой
        SearchSteps.searchFor("Dogs")

        //Создаем и переключаемся на вторую
        String windowHandle = TabManager.getCurrentHandle()
        Set<String> handles = TabManager.getCurrentHandles()
        TabManager.openNewWindow()
        String newHandle = TabManager.waitForNewWindow(handles)
        TabManager.switchToWindow(newHandle)

        //Работаем со второй вкладкой
        SearchSteps.searchFor("Cats")

        //Закрываем и возвращаемся на первую
        TabManager.closeCurrentWindow()
        TabManager.switchToWindow(windowHandle)
    }
}
