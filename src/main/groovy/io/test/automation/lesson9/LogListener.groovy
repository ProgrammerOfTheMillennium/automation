package io.test.automation.lesson9

import com.codeborne.selenide.logevents.LogEvent
import com.codeborne.selenide.logevents.LogEventListener
import groovy.util.logging.Slf4j
import io.qameta.allure.Step

/**
 * Created on 17.09.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

@Slf4j
class LogListener implements LogEventListener {
    @Override
    void onEvent(LogEvent event) {
        switch (event.status) {
            case LogEvent.EventStatus.IN_PROGRESS:
                def text = "IN PROGRESS - ${getLogText(event)}"
                addAllureEvent(text)
                log.info(text)
                break
            case LogEvent.EventStatus.PASS:
                def text = getLogText(event)
                addAllureEvent(text)
                log.info(text)
                break
            case LogEvent.EventStatus.FAIL:
                def text = "${getLogText(event)}\r\n${event.error.toString()}"
                addAllureEvent(text)
                log.error(text)
                break
        }
    }

    @Step("{0}")
    private static addAllureEvent(String step) {
        return step
    }

    private static getLogText(LogEvent event) {
        "${event.element}: ${event.subject}"
    }
}
