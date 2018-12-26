package io.test.automation.lesson8

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Attachment
import io.qameta.allure.Step
import io.test.automation.lesson6.helpers.WaitHelper
import org.awaitility.Duration

/**
 * Created on 26.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class TabManager {

    private static HashMap<String, String> aliasToHandleMap = new HashMap<>()
    private static HashMap<String, String> handleToAliasMap = new HashMap<>()

    private static String getHandleByAlias(String alias) {
        return aliasToHandleMap.get(alias)
    }

    private static void addAlias(String alias, String handle) {
        aliasToHandleMap.put(alias, handle)
        handleToAliasMap.put(handle, alias)
    }

    static void init() {
        def handle = getCurrentHandle()
        addAlias("MAIN", handle)
    }

    static void newTab(String alias) {
        Set<String> handles = getCurrentHandles()
        openNewWindow()
        String newHandle = waitForNewWindow(handles)
        switchToWindow(newHandle)
        addAlias(alias, newHandle)
    }

    static void switchToAlias(String alias) {
        def handle = getHandleByAlias(alias)
        switchToWindow(handle)
    }

    static void closeAndSwitch(String aliasToSwitch) {
        closeCurrentWindow()
        switchToAlias(aliasToSwitch)
    }

    static void closeAndSwitch(String aliasToClose, String aliasToSwitch) {
        switchToAlias(aliasToClose)
        closeCurrentWindow()
        switchToAlias(aliasToSwitch)
    }

    static void cleanUp() {
        aliasToHandleMap.clear()
        handleToAliasMap.clear()
    }

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
        }, Duration.ONE_MINUTE, Duration.ONE_SECOND)
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
