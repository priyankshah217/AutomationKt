package io.framework.automationkt.config

import io.framework.automationkt.pages.PageFooter
import io.framework.automationkt.pages.PageHeader
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AutomationConfig {

    @Value("\${driver.type}")
    lateinit var driverType: String

    @Bean
    fun getHeader(): PageHeader {
        return PageHeader()
    }

    @Bean
    fun getFooter(): PageFooter {
        return PageFooter()
    }

    @Bean
    fun getDriver(): WebDriver? {
        return when (driverType) {
            "firefox", "ff" -> FirefoxDriver()
            "chrome" -> ChromeDriver()
            else -> null
        }
    }
}