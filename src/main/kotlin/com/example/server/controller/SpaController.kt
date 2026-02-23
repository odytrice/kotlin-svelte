package com.example.server.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Forwards all non-API, non-static routes to index.html for client-side routing.
 * This enables SPA (Single Page Application) fallback behavior.
 */
@Controller
class SpaController {

    @RequestMapping(value = ["/{path:^(?!api|public|static)[^\\.]*}/**"])
    fun forward(): String = "forward:/index.html"
}
