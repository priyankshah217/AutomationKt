package io.framework.automationkt.annotations

import org.springframework.stereotype.Component

@Component
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
annotation class Footer
