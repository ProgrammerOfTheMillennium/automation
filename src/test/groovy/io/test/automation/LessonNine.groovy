package io.test.automation

import groovy.util.logging.Slf4j
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

@Slf4j
class LessonNine extends BaseTest {

//    @Test
//    void loggingTestB() {
//        String value = ""
//        if(value == "test") {
//            log.info("Переменная value имеет верное значение")
//        } else {
//            log.error("Переменная ")
//        }
//        log.info("Запущен тест")
//        log.error("Возникла ошибка")
//        log.warn("Предупреждение!!!")
//        log.debug("Отладочная информация")
//        log.trace("Супердетальная низкоуровневая информация")
//    }

    @Test
    void loggingTest() {
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
