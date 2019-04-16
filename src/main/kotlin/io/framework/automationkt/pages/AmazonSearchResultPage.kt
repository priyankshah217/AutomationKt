package io.framework.automationkt.pages

import io.framework.automationkt.annotations.Page
import io.framework.automationkt.pages.base.BasePage


@Page
class AmazonSearchResultPage : BasePage() {
    val searchLink: String = "xpath://h5/a"
    val productTitleLocator: String = "id:productTitle"

    fun selectItemFromList() {
        click(getElementByIndex(searchLink, 1))
    }


    fun getProductTitle(): String? {
        return getElement(productTitleLocator)?.text
    }

    fun switchToAnotherTab() {
        val windowHandles = driver.windowHandles.toTypedArray()
        driver.switchTo().window(windowHandles[1])
    }

}
