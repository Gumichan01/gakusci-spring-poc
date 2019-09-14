package io.arxiv.gumichan01.arxivspringpoc.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ArxivController {

     @GetMapping("/")
     fun home(): String {
         return "Hello Arxiv client\n"
     }
}