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
abstract class Animal {

    String nick
    Integer weight
    String color
    LocalDateTime birthDay

    abstract String getType()
    abstract String getSound()
    abstract String getFood()

    Animal(String nick, Integer weight, String color, LocalDateTime birthDay) {
        this.nick = nick
        this.weight = weight
        this.color = color
        this.birthDay = birthDay
    }

    void voice() {
        log.info("$type $nick: сказал $sound")
    }

    void feed() {
        log.info("$type $nick: скушал $food")
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", nick='" + nick + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
