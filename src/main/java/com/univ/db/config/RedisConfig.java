package com.univ.db.config;

import com.univ.db.model.dao.redis.DiscountOfferHot;
import com.univ.db.model.dao.redis.ItemRecent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 12.05.2017
 */
@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }

    @Bean
    @Qualifier("recent")
    public RedisTemplate<String, ItemRecent> redisItemRecentTemplate() {
        RedisTemplate<String, ItemRecent> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(ItemRecent.class));
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(ItemRecent.class));
        return template;
    }

    @Bean
    @Qualifier("discount")
    public RedisTemplate<String, DiscountOfferHot> redisDiscountTemplate() {
        RedisTemplate<String, DiscountOfferHot> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(ItemRecent.class));
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(ItemRecent.class));
        return template;
    }
}
