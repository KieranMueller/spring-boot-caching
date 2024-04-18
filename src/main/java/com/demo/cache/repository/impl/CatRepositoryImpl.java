//package com.demo.cache.repository.impl;
//
//import com.demo.cache.model.Cat;
//import com.demo.cache.repository.CatRepository;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//import static java.lang.Thread.sleep;
//
//@Component
//public class CatRepositoryImpl implements CatRepository {
//
//    @Override
//    @Cacheable("cats")
//    public Optional<Cat> findById(Long id) {
//        try {
//            sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return new Cat(id, "jasper", "bombay", "black", 4, false);
//    }
//}
