package io.test.automation.lesson10

import com.codeborne.selenide.Selenide

/**
 * Created on 14.01.2019
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class SelenidePage {

    static getNewsLineElement() {
        return Selenide.$(".news-line")
    }

    static open() {
        Selenide.open("https://ru.selenide.org/index.html")
    }
}
