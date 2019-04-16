package io.framework.automationkt.pages

import io.framework.automationkt.annotations.Page
import io.framework.automationkt.pages.base.BasePage

@Page
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