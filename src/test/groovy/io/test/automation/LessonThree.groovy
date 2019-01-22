package io.test.automation

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Selenide
import org.openqa.selenium.By
import org.testng.annotations.Test

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.$$

/**
 * Created on 14.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class LessonThree {
    @Test
    void scheduleTest() {
        Selenide.open("https://rasp.yandex.ru/search")

        def fromField = $("#from")
        def toField = $("#to")
        def whenField = $("#when")
        def findButton = $("button.SearchForm__submit")

        fromField.value = "Великий Новгород"
        toField.value = "Москва"
        whenField.value = "сегодня"
        findButton.click()

        def foundRecords = $$("article.SearchSegment_isVisible")

        foundRecords.shouldBe(CollectionCondition.sizeGreaterThan(1))

        foundRecords.each {
            def recordName = it.$(By.className("SegmentTitle__header"))
            def recordDuration = it.$(By.className("SearchSegment__duration"))

            println("$recordName.text : $recordDuration.text")
        }
    }
}
