package com.u2d.playground.service

import com.u2d.playground.domain.Account

interface BankService {
    fun findAll(): List<Account>
}