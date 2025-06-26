package com.bfaydali.bookinventory.testutils

import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockHttpServletRequestDsl

fun MockHttpServletRequestDsl.jsonContent(requestContext: String): MockHttpServletRequestDsl {
    content = requestContext
    contentType = APPLICATION_JSON
    return this
}