package io.test.automation

import groovy.util.logging.Slf4j
import io.test.automation.lesson12.Animal
import io.test.automation.lesson12.Cat
import io.test.automation.lesson12.Dog
import org.testng.annotations.Test

import java.time.LocalDateTime

/**
 * Created on 24.01.2019
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */
@Slf4j
class Lesson12 {
    @Test
    public void testClasses() {
        List<Animal> animals = []

        animals.add(new Cat("Мурка", 5, "рыжая", LocalDateTime.now().minusYears(1)))
        animals.add(new Cat("Васька", 10, "черный", LocalDateTime.now().minusYears(1)))
        animals.add(new Dog("Бобик", 20, "белый"))
        animals.add(new Dog("Полкан", 40, "серый"))

        animals.forEach(
                {
                    it.voice()
                    it.food
                    log.info(it.toString())
                }
        )
    }
}
