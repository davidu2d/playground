package com.u2d.playground.service.impl

import com.u2d.playground.domain.Account
import com.u2d.playground.repository.BankRepository
import com.u2d.playground.service.BankService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.extension.ExtendWith

@Disabled
@ExtendWith(MockKExtension::class)
class BankServiceImplTest {

    @MockK
    private lateinit var bankRepository: BankRepository

    @InjectMockKs
    private lateinit var bankService: BankService

    @Test
    fun `should return all account`() {
        val fakeAccounts = listOf(buildAccount())
        every { bankRepository.findAll() } returns fakeAccounts

        val accounts = bankService.findAll()

        assertEquals(fakeAccounts, accounts)
    }

    fun buildAccount(
        agency: String = "0101",
        numberAccount: String = "5252-2",
        type: String = "PF"
    ) = Account(agency = agency, numberAccount = numberAccount, type = type)
}