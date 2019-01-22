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
abstract class Lesson11BaseTest {

    @BeforeSuite(alwaysRun = true)
    @Step
    void setUpSuite() {
        log.info("Before Suite Base")
        pause()
    }

    @AfterSuite(alwaysRun = true)
    @Step
    void tearDownSuite() {
        log.info("After Suite Base")
        pause()
    }

    @BeforeTest(groups = "TEST_A")
    @Step
    void setUpTest_TestA() {
        log.info("Before Test TEST_A")
        pause()
    }

    @AfterTest(groups = "TEST_A")
    @Step
    void tearDownTest_TestA() {
        log.info("After Test TEST_A")
        pause()
    }

    @BeforeTest(groups = "CLASS_B")
    @Step
    void setUpTest_ClassB() {
        log.info("Before Test CLASS_B")
        pause()
    }

    @AfterTest(groups = "CLASS_B")
    @Step
    void tearDownTest_ClassB() {
        log.info("After Test CLASS_B")
        pause()
    }

    @BeforeTest(alwaysRun = true)
    @Step
    void setUpTest() {
        log.info("Before Test Base")
        pause()
    }

    @AfterTest(alwaysRun = true)
    @Step
    void tearDownTest() {
        log.info("After Test Base")
        pause()
    }

    @BeforeGroups(value = "TEST_A")
    @Step
    void setUpGroupTestA() {
        log.info("Before Group TEST_A")
        pause()
    }

    @AfterGroups(value = "TEST_A")
    @Step
    void tearDownGroupTestA() {
        log.info("After Group TEST_A")
        pause()
    }

    @BeforeGroups(value = "CLASS_B")
    @Step
    void setUpGroupClassB() {
        log.info("Before Group CLASS_B")
        pause()
    }

    @AfterGroups(value = "CLASS_B")
    @Step
    void tearDownGroupClassB() {
        log.info("After Group CLASS_B")
        pause()
    }

    @BeforeClass(alwaysRun = true)
    @Step
    void setUpClassBase() {
        log.info("Before Class In Base")
        pause()
    }

    @AfterClass(alwaysRun = true)
    @Step
    void tearDownClassBase() {
        log.info("After Class In Base")
        pause()
    }

    @BeforeMethod(alwaysRun = true)
    @Step
    void setUpBase() {
        log.info("Before Method Base")
        pause()
    }

    @AfterMethod(alwaysRun = true)
    @Step
    void tearDownBase() {
        log.info("After Method Base")
        pause()
    }

    static void pause() {
        Thread.currentThread().sleep(1000)
    }
}
