package io.test.automation

import groovy.util.logging.Slf4j
import io.qameta.allure.Step
import org.testng.annotations.*

/**
 * Created on 21.01.2019
 *
 * @author Yuri Kudryavtsev
 *         skype: yuri.kudryavtsev.indeed
 *         email: ykudryavtsev@maxilect.com
 */
@Slf4j
class Lesson11A extends Lesson11BaseTest {

    @BeforeClass(alwaysRun = true)
    @Step
    void setUpClass() {
        log.info("Before Class In Lesson11A")
        pause()
    }

    @AfterClass(alwaysRun = true)
    @Step
    void tearDownClass() {
        log.info("After Class In Lesson11A")
        pause()
    }

    @BeforeMethod(alwaysRun = true)
    @Step
    void setUp() {
        log.info("Before Method In Lesson11A")
        pause()
    }

    @AfterMethod(alwaysRun = true)
    @Step
    void tearDown() {
        log.info("After Method In Lesson11A")
        pause()
    }

    @Test(groups = ["CLASS_A","TEST_A"])
    @Step
    void testAA() {
        log.info("Test Method A in 11A")
        pause()
    }

    @Test(groups = ["CLASS_A","TEST_B"])
    @Step
    void testAB() {
        log.info("Test Method B in 11A")
        pause()
    }
}
