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
class Lesson11B extends Lesson11BaseTest {

    @BeforeClass(alwaysRun = true)
    @Step
    void setUpClass() {
        log.info("Before Class In Lesson11B")
        pause()
    }

    @AfterClass(alwaysRun = true)
    @Step
    void tearDownClass() {
        log.info("After Class In Lesson11B")
        pause()
    }

    @BeforeMethod(alwaysRun = true)
    @Step
    void setUp() {
        log.info("Before Method In Lesson11B")
        pause()
    }

    @AfterMethod(alwaysRun = true)
    @Step
    void tearDown() {
        log.info("After Method In Lesson11B")
        pause()
    }

    @Test(groups = ["CLASS_B","TEST_A"])
    @Step
    void testBA() {
        log.info("Test Method A in 11B")
        pause()
    }

    @Test(groups = ["CLASS_B","TEST_B"])
    @Step
    void testBB() {
        log.info("Test Method B in 11B")
        pause()
    }
}
