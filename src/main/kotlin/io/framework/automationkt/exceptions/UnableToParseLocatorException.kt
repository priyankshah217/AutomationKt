package io.framework.automationkt.exceptions

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class UnableToParseLocatorException() : RuntimeException() {
    private val logger: Logger = LoggerFactory.getLogger(UnableToParseLocatorException::class.java)

    constructor(searchLocatorWithValue: String) : this() {
        logger.debug(searchLocatorWithValue)
    }
}
