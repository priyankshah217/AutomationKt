package io.framework.automationkt.pages

import org.springframework.stereotype.Component

@Component
class AmazonSearchResultPage : BasePage() {
    val searchLink: String = "css:span.a-size-medium.a-color-base.a-text-normal"
    val productTitleLocator: String = "id:productTitle"


    fun selectItemFromList() {
        click(searchLink)
    }

    fun getProductTitle(): String? {
        return getElement(productTitleLocator)?.text
    }

    fun switchToAnotherTab() {
        val windowHandles = driver.windowHandles.toTypedArray()
        driver.switchTo().window(windowHandles[1])
    }

}
