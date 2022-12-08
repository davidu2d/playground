package com.u2d.playground.service.impl

import com.hazelcast.core.HazelcastInstance
import com.u2d.playground.domain.Account
import com.u2d.playground.service.HazelcastService
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentMap

@Service
class HazelcastServiceImpl(val hazelcastInstance: HazelcastInstance) : HazelcastService {

    private fun retrieveMap(): ConcurrentMap<String, List<Account>> {
        return hazelcastInstance.getMap("accounts")
    }

    override fun put(accounts: List<Account>) {
        retrieveMap().put("accounts", accounts)
    }

    override fun get(key: String): List<Account> {
        return retrieveMap().get(key) ?: listOf()
    }
}