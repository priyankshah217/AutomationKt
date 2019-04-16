package io.framework.automationkt.annotations

import org.springframework.stereotype.Component

@Component
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class Page
