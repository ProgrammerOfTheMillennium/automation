package io.test.automation

import org.openqa.selenium.By
import org.testng.annotations.Test

import static com.codeborne.selenide.Selenide.*

/**
 * Created on 11.12.2018
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */
class LessonTwo {

    @Test
    void searchTest() {
        def searchRequest = "Cat"

        open("https://google.com/")
        def searchInput = $(By.name("q"))
        searchInput.value = searchRequest
        searchInput.pressEnter()

        def found = $$("#ires .g")
        assert found.size() > 0
        assert found.first().text.contains(searchRequest)
    }
}
