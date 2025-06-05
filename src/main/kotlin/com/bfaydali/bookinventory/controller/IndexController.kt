package com.bfaydali.bookinventory.controller

import io.swagger.v3.oas.annotations.Hidden
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.view.RedirectView

@Hidden
@RestController
@RequestMapping("/")
class IndexController {

    @GetMapping
    fun redirectToSwagger() = RedirectView("/swagger-ui/index.html")
}