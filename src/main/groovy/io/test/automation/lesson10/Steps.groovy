package io.test.automation.lesson10

import com.codeborne.selenide.SelenideElement
import groovy.util.logging.Slf4j

/**
 * Created on 14.01.2019
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */

@Slf4j
class Steps {

    static logElementInfo(SelenideElement element) {
        log.info("Visible text: " + element.text())
        log.info("Inner text: " + element.innerText())
        log.info("Inner html: " + element.innerHtml())
        log.info("Id: " + element.attr("id"))
        log.info("Classes: " + element.attr("class"))
        log.info("Style: " + element.attr("style"))
        log.info("Color: " + element.getCssValue("color"))
        log.info("Tag: " + element.getTagName())
        def coordinates = element.getCoordinates()
        def location = element.getLocation()
        log.info("Location: " + location)
        def rect = element.getRect()
        def size = element.getSize()
        log.info("Size: " + size)
    }
}
