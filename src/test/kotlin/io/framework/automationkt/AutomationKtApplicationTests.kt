package io.framework.automationkt


import io.framework.automationkt.pages.AmazonHomePage
import io.framework.automationkt.pages.AmazonSearchResultPage
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class AutomationKtApplicationTests : BaseTest() {

    @Autowired
    lateinit var amazonSearchResultPage: AmazonSearchResultPage

    @Autowired
    lateinit var amazonHomePage: AmazonHomePage

    @Test
    @DirtiesContext
    fun `I should be able to search item on amazon portal`() {
        amazonHomePage.searchItem("Computer")
        amazonSearchResultPage.selectItemFromList()
        amazonSearchResultPage.switchToAnotherTab()
        amazonSearchResultPage.getProductTitle()?.contains("Wintech")?.let { assertTrue(it) }
    }

    @Test
    @DirtiesContext
    fun `I should be able to open any category`() {
        amazonHomePage.openAnyCategory()
    }

}
