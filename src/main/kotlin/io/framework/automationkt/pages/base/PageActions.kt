package io.framework.automationkt.pages.base

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

interface PageActions {
    fun isElementPresent(by: By?): Boolean
    fun isElementPresent(webElement: WebElement?): Boolean
    fun click(by: By)
    fun click(webElement: WebElement?)
    fun sendText(webElement: WebElement, text: String)
    fun sendText(by: By, text: String)
}