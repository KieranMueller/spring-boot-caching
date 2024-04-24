package com.demo.cache.service;

import com.demo.cache.entity.Cat;
import com.demo.cache.repository.CatRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Thread.sleep;

@Service
@Slf4j
@RequiredArgsConstructor
@CacheConfig(cacheNames = "catCache")
public class CatService {

    private final CatRepository catRepository;
    private final CacheManager cacheManager;

    @Cacheable
    public List<Cat> findAllCats() {
        log.info("In CatService::findAllCats");
        mockWaitTime();
        return catRepository.findAll();
    }

    @Cacheable(key = "#id")
    public Cat findCatById(Long id) {
        log.info("In CatService::findCatById with id: {}", id);
        mockWaitTime();
        return catRepository.findById(id).orElseThrow();
    }

    @CachePut(key = "#cat.id")
    public Cat createCat(Cat cat) {
        log.info("In CatService::createCat with cat: {}", cat);
        Cat savedCat = catRepository.save(cat);
        log.info("CatService::createCat saved cat: {}", savedCat);
        return savedCat;
    }

    private void mockWaitTime() {
        log.info("Mocking wait time for {}ms", 2000);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
