package com.demo.cache.config;

import com.demo.cache.entity.Cat;
import com.demo.cache.repository.CatRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Objects;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CacheConfig {

    private final CatRepository catRepository;
    private final CacheManager cacheManager;

    @PostConstruct
    private void prePopulateDatabase() {
        log.info("In CacheConfig::prePopulateDatabase. Populating database . . .");
        catRepository.saveAll(List.of(
                new Cat(1L, "Mittens", "Calico", "Orange", 2, true),
                new Cat(2L, "Stanley", "Shorthair", "White", 12, false),
                new Cat(3L, "Biscuit", "Abyssinian", "Orange", 5, false),
                new Cat(4L, "Hansel", "Bombay", "Black", 8, false)
        ));
        log.info("End of CacheConfig::prePopulateDatabase. Successfully populated database");
        prePopulateCacheFromDatabase();
    }

    private void prePopulateCacheFromDatabase() {
        log.info("In CacheConfig::prePopulateCacheFromDatabase. Populating cache . . .");
        catRepository.findAll().forEach(cat -> Objects.requireNonNull(cacheManager.getCache("catCache")).put(cat.getId(), cat));
        log.info("End of CacheConfig::prePopulateCacheFromDatabase. Successfully populated cache");
    }
}
