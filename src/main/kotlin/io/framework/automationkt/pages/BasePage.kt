package io.framework.automationkt.pages

import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired

class BasePage : PageFragment() {


    @Autowired
    lateinit var pageHeader: PageHeader

    @Autowired
    lateinit var pageFooter: PageFooter

    override var driver: WebDriver
        get() = super.driver
        set(value) {}

}