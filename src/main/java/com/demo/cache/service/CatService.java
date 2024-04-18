package com.demo.cache.service;

import com.demo.cache.entity.Cat;
import com.demo.cache.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Thread.sleep;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    public List<Cat> findAllCats() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return catRepository.findAll();
    }

    public Cat findCatById(Long id) {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return catRepository.findById(id).orElseThrow();
    }

    public Cat createCat(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat updateCat(Cat cat, Long id) {
        Cat dbCat = catRepository.findById(id).orElseThrow();
        if (cat.getName() != null && !cat.getName().isBlank())
            dbCat.setName(cat.getName());
        if (cat.getBreed() != null && !cat.getBreed().isBlank())
            dbCat.setBreed(cat.getBreed());
        if (cat.getColor() != null && !cat.getColor().isBlank())
            dbCat.setColor(cat.getColor());
        if (cat.getAge() > 0)
            dbCat.setAge(cat.getAge());
        dbCat.setOverweight(cat.isOverweight());
        return catRepository.save(dbCat);
    }

    public Cat deleteCatById(Long id) {
        Cat cat = catRepository.findById(id).orElseThrow();
        catRepository.delete(cat);
        return cat;
    }
}
