package com.u2d.playground.repository

import com.u2d.playground.domain.Account
import org.springframework.stereotype.Repository

@Repository
class BankRepository {

    fun findAll(): List<Account> {
        return listOf(Account("0101", "5353-3", type = "PF"))
    }
}