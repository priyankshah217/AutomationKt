package io.framework.automationkt.pages

import io.framework.automationkt.exceptions.UnableToParseLocatorException
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class PageFragment : PageActions {

    @Autowired
    open lateinit var driver: WebDriver

    @Value("\${explicit.timeout}")
    lateinit var waitTime: String

    private val logger: Logger = LoggerFactory.getLogger(PageFragment::class.java)

//    override fun launchUrl(url: String) {
//        driver.get(url)
//    }

    override fun isElementPresent(by: By): Boolean {
        val wait = WebDriverWait(driver, waitTime.toLong())
        return try {
            wait.until(ExpectedConditions.elementToBeClickable(by)).isDisplayed
        } catch (ex: NoSuchElementException) {
            logger.debug("Element not found $by ")
            false
        }
    }

    override fun isElementPresent(webElement: WebElement): Boolean {
        val wait = WebDriverWait(driver, waitTime.toLong())
        return try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement)).isDisplayed
        } catch (ex: NoSuchElementException) {
            logger.debug("Element not found $webElement ")
            false
        }
    }

    override fun click(by: By) {
        if (isElementPresent(by)) {
            click(driver.findElement(by))
        } else {
            logger.debug("Unable to click on $by")
        }
    }

    override fun sendText(by: By, text: String) {
        if (isElementPresent(by)) {
            sendText(driver.findElement(by), text)
        } else {
            logger.debug("Unable to enter text to $by")
        }
    }

    override fun click(webElement: WebElement) {
        if (isElementPresent(webElement)) {
            webElement.click()
        } else {
            logger.debug("Unable to click on $webElement")
        }
    }

    override fun sendText(webElement: WebElement, text: String) {
        if (isElementPresent(webElement)) {
            webElement.sendKeys(text)
        } else {
            logger.debug("Unable to enter text to $webElement")
        }
    }

    fun click(searchLocatorWithValue: String) {
        val searchBy = searchLocatorWithValue.split(":")[0]
        val searchByValue = searchLocatorWithValue.split(":")[1]
        when (searchBy) {
            "id" -> click(By.id(searchByValue))
            "xpath" -> click(By.xpath(searchByValue))
            "css" -> click(By.cssSelector(searchByValue))
            "class" -> click(By.className(searchByValue))
            "tag" -> click(By.tagName(searchByValue))
            "name" -> click(By.name(searchByValue))
            else -> throw UnableToParseLocatorException(searchLocatorWithValue)
        }
    }
}