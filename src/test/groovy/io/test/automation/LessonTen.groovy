package io.test.automation

import com.codeborne.selenide.Condition
import groovy.util.logging.Slf4j
import io.test.automation.lesson10.SelenidePage
import io.test.automation.lesson10.Steps
import io.test.automation.lesson10.YandexPage
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * Created on 14.01.2019
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

@Slf4j
class LessonTen {

    public static final String COLOR_RED = "rgba(204, 0, 0, 1)"
    public static final String COLOR_BLUE = "rgba(0, 84, 185, 1)"

    @BeforeMethod
    void setUp() {
        log.info("Begin of test")
    }

    @AfterMethod
    void tearDown() {
        log.info("End of test")
    }

    @Test
    void attributesYandex() {
        YandexPage.open()
        log.info("Кнопка поиска видео - до наведения")
        Steps.logElementInfo(YandexPage.videoTabButton)
        log.info("Кнопка поиска видео - после наведения")
        YandexPage.videoTabButton.hover()
        Steps.logElementInfo(YandexPage.videoTabButton)
        log.info("End of test")
    }

    @Test
    void attributesYandexWhile() {
        YandexPage.open()

        def color = ""
        while (color != COLOR_RED) {
            color = YandexPage.videoTabButton.getCssValue("color")
            if (color != COLOR_BLUE) {
                log.info("Current color: $color")
            }
        }
    }

    @Test
    void attributesYandexWait() {
        YandexPage.open()
        YandexPage.videoTabButton.waitUntil(
                Condition.cssValue("color", COLOR_RED),
                60000)
    }

    @Test
    void attributesSelenide() {
        SelenidePage.open()
        Steps.logElementInfo(SelenidePage.newsLineElement)
    }
}
