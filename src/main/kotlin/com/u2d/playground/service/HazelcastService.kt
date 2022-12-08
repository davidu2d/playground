package com.u2d.playground.service

import com.u2d.playground.domain.Account

interface HazelcastService {

    fun put(accounts: List<Account>)
    fun get(key: String): List<Account>
}