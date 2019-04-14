package io.framework.automationkt.pages

import org.springframework.stereotype.Component

@Component
class AmazonHomePage : BasePage() {

    fun searchItem(searchString: String) {
        sendText(pageHeader.searchBoxLocator, searchString)
        submitForm(pageHeader.searchFormLocator)
    }
}