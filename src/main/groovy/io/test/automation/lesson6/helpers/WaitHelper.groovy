package io.test.automation.lesson6.helpers

import org.awaitility.Awaitility
import org.awaitility.Duration
import org.awaitility.core.ThrowingRunnable

import java.util.concurrent.Callable


/**
 * Created on 21.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class WaitHelper {
    static waitFor(ThrowingRunnable assertion, Duration timeout, Duration interval) {
        Awaitility.await().
                atMost(timeout).
                pollInterval(interval).
                pollInSameThread().
                ignoreExceptions().
                untilAsserted(assertion)
    }

    static waitFor(ThrowingRunnable assertion) {
        waitFor(assertion, Duration.ONE_MINUTE, Duration.FIVE_SECONDS)
    }

    static waitFor(String message, Callable<Boolean> callable, Duration timeout, Duration interval) {
        Awaitility.await(message).
                atMost(timeout).
                pollInterval(interval).
                pollInSameThread().
                ignoreExceptions().
                until(callable)
    }

    static waitFor(String message, Callable<Boolean> callable) {
        waitFor(message, callable, Duration.ONE_MINUTE, Duration.FIVE_SECONDS)
    }
}
