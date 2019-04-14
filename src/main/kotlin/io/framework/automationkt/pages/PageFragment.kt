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
    lateinit var driver: WebDriver

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

    private fun getElement(webElement: WebElement): WebElement? {
        return if (isElementPresent(webElement))
            webElement
        else
            null
    }

    fun getElement(searchLocatorWithValue: String): WebElement? {
        val (searchBy, searchByValue) = extractLocatorsFromProperties(searchLocatorWithValue)
        return when (searchBy) {
            "id" -> getElement(By.id(searchByValue))
            "xpath" -> getElement(By.xpath(searchByValue))
            "css" -> getElement(By.cssSelector(searchByValue))
            "class" -> getElement(By.className(searchByValue))
            "tag" -> getElement(By.tagName(searchByValue))
            "name" -> getElement(By.name(searchByValue))
            else -> throw UnableToParseLocatorException(searchLocatorWithValue)
        }
    }

    private fun getElement(by: By): WebElement? {
        return if (isElementPresent(by))
            return getElement(driver.findElement(by))
        else
            null
    }

    private fun getElements(by: By): List<WebElement>? {
        return if (isElementPresent(by))
            return driver.findElements(by)
        else
            null
    }

    fun getElementByIndex(by: By, int: Int): WebElement? {
        return getElements(by)?.get(int)
    }

    override fun click(by: By) {
        getElement(by)?.click()
    }

    override fun sendText(by: By, text: String) {
        getElement(by)?.sendKeys(text)
    }

    override fun sendText(webElement: WebElement, text: String) {
        getElement(webElement)?.sendKeys(text)
    }

    override fun click(webElement: WebElement) {
        getElement(webElement)?.click()
    }

    fun click(searchLocatorWithValue: String) {
        val (searchBy, searchByValue) = extractLocatorsFromProperties(searchLocatorWithValue)
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

    fun sendText(searchLocatorWithValue: String, textValue: String) {
        val (searchBy, searchByValue) = extractLocatorsFromProperties(searchLocatorWithValue)
        when (searchBy) {
            "id" -> sendText(By.id(searchByValue), textValue)
            "xpath" -> sendText(By.xpath(searchByValue), textValue)
            "css" -> sendText(By.cssSelector(searchByValue), textValue)
            "class" -> sendText(By.className(searchByValue), textValue)
            "tag" -> sendText(By.tagName(searchByValue), textValue)
            "name" -> sendText(By.name(searchByValue), textValue)
            else -> throw UnableToParseLocatorException(searchLocatorWithValue)
        }
    }

    private fun extractLocatorsFromProperties(searchLocatorWithValue: String): Pair<String, String> {
        val searchBy = searchLocatorWithValue.split(":")[0]
        val searchByValue = searchLocatorWithValue.split(":")[1]
        return Pair(searchBy, searchByValue)
    }

    fun submitForm(searchLocatorWithValue: String) {
        val (searchBy, searchByValue) = extractLocatorsFromProperties(searchLocatorWithValue)
        when (searchBy) {
            "id" -> getElement(By.id(searchByValue))?.submit()
            "xpath" -> getElement(By.xpath(searchByValue))?.submit()
            "css" -> getElement(By.cssSelector(searchByValue))?.submit()
            "class" -> getElement(By.className(searchByValue))?.submit()
            "tag" -> getElement(By.tagName(searchByValue))?.submit()
            "name" -> getElement(By.name(searchByValue))?.submit()
            else -> throw UnableToParseLocatorException(searchLocatorWithValue)
        }
    }
}