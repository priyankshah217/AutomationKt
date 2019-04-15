package io.framework.automationkt.pages

import org.springframework.stereotype.Component

@Component
class AmazonHomePage : BasePage() {
    val categoryIdLocator = "id:desktop-grid-1"

    fun searchItem(searchString: String) {
        sendText(pageHeader.searchBoxLocator, searchString)
        submitForm(pageHeader.searchFormLocator)
    }

    fun openAnyCategory() {
        click(categoryIdLocator)
    }
}