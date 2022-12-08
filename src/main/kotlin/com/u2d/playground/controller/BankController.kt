package com.u2d.playground.controller

import com.u2d.playground.service.BankService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("bank/account")
class BankController(val bankService: BankService) {

    @GetMapping
    fun findAll() = ResponseEntity.ok(ResponseEntity.ok(bankService.findAll()))
}