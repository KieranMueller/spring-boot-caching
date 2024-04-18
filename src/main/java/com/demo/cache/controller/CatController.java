package com.demo.cache.controller;

import com.demo.cache.entity.Cat;
import com.demo.cache.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class CatController {

    private final CatService catService;

    @GetMapping("cats")
    @Cacheable("catCache")
    public List<Cat> findAllCats() {
        return catService.findAllCats();
    }

    @GetMapping("cats/{id}")
    @Cacheable("catCache")
    public Cat findCatById(@PathVariable Long id) {
        return catService.findCatById(id);
    }

    @PostMapping("cats")
    @CacheEvict(value = "catCache", allEntries = true)
    public Cat createCat(@RequestBody Cat cat) {
        return catService.createCat(cat);
    }

    @PutMapping("cats/{id}")
    @CacheEvict(value = "catCache", allEntries = true)
    public Cat updateCat(@RequestBody Cat cat, @PathVariable Long id) {
        return catService.updateCat(cat, id);
    }

    @DeleteMapping("cats/{id}")
    @CacheEvict(value = "catCache", allEntries = true)
    public Cat deleteCatById(@PathVariable Long id) {
        return catService.deleteCatById(id);
    }
}
