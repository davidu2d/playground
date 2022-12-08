package com.u2d.playground.config

import com.hazelcast.config.Config
import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HazelcastConfig {

    @Bean
    fun hazelcastInstance(): HazelcastInstance{
        var cfg = Config()
        cfg.getMapConfig("accounts")
        cfg.networkConfig.join.multicastConfig.isEnabled = false
        cfg.networkConfig.join.kubernetesConfig.isEnabled = true
        return Hazelcast.newHazelcastInstance(cfg)
    }
}