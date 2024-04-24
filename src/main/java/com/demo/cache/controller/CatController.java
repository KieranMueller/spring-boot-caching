package com.demo.cache.controller;

import com.demo.cache.entity.Cat;
import com.demo.cache.service.CatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/v1")
public class CatController {

    private final CatService catService;
    private final CacheManager cacheManager;

    @GetMapping("cats")
    public List<Cat> findAllCats() {
        log.info("In CatController::findAllCats");
        return catService.findAllCats();
    }

    @GetMapping("cats/{id}")
    public Cat findCatById(@PathVariable Long id) {
        log.info("In CatController::findCatById with id: {}", id);
        return catService.findCatById(id);
    }

    @PostMapping("cats")
    public Cat createCat(@RequestBody Cat cat) {
        log.info("In CatController::createCat with cat: {}", cat);
        return catService.createCat(cat);
    }
}
