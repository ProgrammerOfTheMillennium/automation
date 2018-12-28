package io.test.automation.lesson9

import com.codeborne.selenide.logevents.LogEvent
import com.codeborne.selenide.logevents.LogEventListener
import groovy.util.logging.Slf4j

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
                log.info("IN PROGRESS - ${getLogText(event)}")
                break
            case LogEvent.EventStatus.PASS:
                log.info(getLogText(event))
                break
            case LogEvent.EventStatus.FAIL:
                log.error("${getLogText(event)}\r\n${event.error.toString()}")
                break
        }
    }

    private static getLogText(LogEvent event) {
        "${event.element}: ${event.subject}"
    }
}
