package io.framework.automationkt.pages

import org.springframework.stereotype.Component

@Component
class AmazonHomePage : BasePage() {

    fun searchItem() {
        click(pageHeader.searchBoxLocator)
    }
}