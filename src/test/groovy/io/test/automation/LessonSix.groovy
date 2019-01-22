package io.test.automation


import io.test.automation.lesson6.steps.SearchSteps
import org.awaitility.Awaitility
import org.awaitility.Duration
import org.testng.annotations.Test

import java.util.concurrent.TimeUnit

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.equalTo

/**
 * Created on 21.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class LessonSix {
    @Test
    void checkWaits() {
        Awaitility.await().
                atMost(new Duration(30, TimeUnit.SECONDS)). //таймаут в 30 секунд
                pollInterval(Duration.FIVE_SECONDS). //проверяем каждые 5 секунд
                pollInSameThread(). //проверяем в том же потоке, что и вызвали Awaitility.await()
                ignoreExceptions(). //игнорируем все исключения, кроме AssertionError
                untilAsserted({ //ждем, что ассерт не выкинет исключение AssertionError
                    assertThat(
                            "Неправильный поисковый запрос", //сообщение об ошибке в случае таймаута
                            SearchSteps.getCurrentSearchRequest(), //вызов метода, который возвращает реальный результат
                            equalTo("котики"))
                    //инструкция по проверке - актуальный результат должен быть равен "котики"
                })

//        WaitHelper.waitFor({
//            assertThat(
//                    "Неправильный поисковый запрос",
//                    SearchSteps.getCurrentSearchRequest(),
//                    equalTo("котики"))
//        })
    }
}
