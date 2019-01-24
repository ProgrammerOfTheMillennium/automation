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
class Cat extends Animal {
    Cat(String nick, Integer weight, String color, LocalDateTime birthDay) {
        super(nick, weight, color, birthDay)
    }

    @Override
    String getType() {
        "Котик"
    }

    @Override
    String getSound() {
        "мяу"
    }

    @Override
    String getFood() {
        "рыбка"
    }

}
