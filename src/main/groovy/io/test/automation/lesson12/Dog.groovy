package io.test.automation.lesson12

import groovy.util.logging.Slf4j

import java.time.LocalDateTime

/**
 * Created on 24.01.2019
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

@Slf4j
class Dog extends Animal {
    Dog(String nick, Integer weight, String color) {
        super(nick, weight, color, LocalDateTime.now())
    }

    @Override
    String getType() {
        "Собачки"
    }

    @Override
    String getSound() {
        "гав-гав"
    }

    @Override
    String getFood() {
        "косточку"
    }

}
