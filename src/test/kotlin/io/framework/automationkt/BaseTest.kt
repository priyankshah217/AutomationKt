package io.framework.automationkt

import org.junit.Before
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired

open class BaseTest {

    @Autowired
    lateinit var webDriver: WebDriver

    @Before
    fun setUp() {
        webDriver.get("https://www.amazon.in")
    }
}