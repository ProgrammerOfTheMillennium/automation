package io.test.automation.lesson8

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Attachment
import io.qameta.allure.Step
import io.test.automation.lesson6.helpers.WaitHelper

/**
 * Created on 26.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class TabManager {

    @Step("Переключаемся на окно: {0}")
    static void switchToWindow(String handle) {
        Selenide.switchTo().window(handle)
    }

    @Step("Закрываем текущее окно")
    static void closeCurrentWindow() {
        WebDriverRunner.webDriver.close()
    }

    @Step("Получаем идентификатор текущего окна")
    @Attachment
    static String getCurrentHandle() {
        return WebDriverRunner.getWebDriver().windowHandle
    }

    @Step("Открываем новое окно")
    static void openNewWindow() {
        Selenide.executeJavaScript("window.open('about:blank','_blank');")
    }

    @Step("Получаем идентификаторы открытых окон")
    @Attachment
    static Set<String> getCurrentHandles() {
        return WebDriverRunner.getWebDriver().windowHandles
    }

    @Step("Ожидаем появления нового окна")
    @Attachment(value = "Идентификатор нового окна")
    static String waitForNewWindow(Set<String> oldHandles) {
        String newHandle = null
        WaitHelper.waitFor("появится новое окно", {
            newHandle = getHandleOfNewWindow(oldHandles)
            newHandle != null
        })
        return newHandle
    }

    private static String getHandleOfNewWindow(Set<String> oldHandles) {
        String newHandle = null
        Set<String> newHandles = WebDriverRunner.webDriver.windowHandles - oldHandles
        if (!newHandles.isEmpty()) {
            newHandle = newHandles.first()
        }
        return newHandle
    }
}
