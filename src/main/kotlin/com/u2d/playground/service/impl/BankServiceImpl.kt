package com.u2d.playground.service.impl

import com.u2d.playground.domain.Account
import com.u2d.playground.repository.BankRepository
import com.u2d.playground.service.BankService
import com.u2d.playground.service.HazelcastService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BankServiceImpl(private val bankRepository: BankRepository, private val hazelcastService: HazelcastService): BankService {

    val logger: Logger = LoggerFactory.getLogger(BankServiceImpl::class.java)

    override fun findAll(): List<Account> {
        logger.info("Gel all Accounts")
        var accounts = hazelcastService.get("accounts")
        if (!accounts.isNullOrEmpty()){
            logger.info("Accounts from cache")
            return accounts
        }
        logger.info("Accounts from db")
        val accountDb = bankRepository.findAll()
        hazelcastService.put(accountDb)
        return accountDb
    }
}