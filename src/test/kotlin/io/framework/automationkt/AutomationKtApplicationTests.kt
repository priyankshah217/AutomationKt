package io.framework.automationkt

import io.framework.automationkt.pages.AmazonHomePage
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class AutomationKtApplicationTests : BaseTest(){

	@Autowired
	lateinit var amazonHomePage: AmazonHomePage

	@Test
	fun `Launch amazon home page`() {
		amazonHomePage.searchItem()
	}

}
