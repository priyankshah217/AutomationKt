package io.framework.automationkt.pages

import io.framework.automationkt.annotations.Footer
import io.framework.automationkt.annotations.Header
import org.openqa.selenium.WebDriver

class BasePage : PageFragment() {

    @Header
    lateinit var pageHeader: PageHeader

    @Footer
    lateinit var pageFooter: PageFooter

    override var driver: WebDriver
        get() = super.driver
        set(value) {}
    
}