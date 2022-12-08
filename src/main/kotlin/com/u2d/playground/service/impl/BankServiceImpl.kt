package com.u2d.playground.service.impl

import com.u2d.playground.domain.Account
import com.u2d.playground.repository.BankRepository
import com.u2d.playground.service.BankService
import org.springframework.stereotype.Service

@Service
class BankServiceImpl(private val bankRepository: BankRepository): BankService {

    override fun findAll(): List<Account> {
        return bankRepository.findAll()
    }
}