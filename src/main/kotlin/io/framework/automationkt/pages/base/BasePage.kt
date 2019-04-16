package io.framework.automationkt.pages.base

import org.springframework.beans.factory.annotation.Autowired

class BasePage : PageFragment() {

    @Autowired
    lateinit var pageHeader: PageHeader

    @Autowired
    lateinit var pageFooter: PageFooter
}