package io.test.automation.lesson10

import com.codeborne.selenide.Selenide

/**
 * Created on 14.01.2019
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

class YandexPage {
    static getVideoTabButton() {
        return Selenide.$("[role='navigation'] [data-id='video']")
    }

    static open() {
        Selenide.open("https://yandex.ru/")
    }
}
