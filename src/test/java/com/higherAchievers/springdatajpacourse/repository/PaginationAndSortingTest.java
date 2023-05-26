package com.higherAchievers.springdatajpacourse.repository;

import com.higherAchievers.springdatajpacourse.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void pagination(){
        int pageNo = 0;
        int pageSize = 5;

        //create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        //call findAll method and pass pageable instance
        Page<Product> page  = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach(System.out::println);

        //total pages
        int totalPages = page.getTotalPages();

        //total elements
        long totalElements = page.getTotalElements();

        //number of elements
        int numberOfElements = page.getNumberOfElements();

        //size
        int size = page.getSize();

        //last
        boolean isLast = page.isLast();

        //first
        boolean first = page.isFirst();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("numberOfElements = " + numberOfElements);
        System.out.println("size = " + size);
        System.out.println("isLast = " + isLast);
        System.out.println("first = " + first);

    }

    @Test
    void sorting(){

        String sortBy = "price";
        String sortDir = "desc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();



        List<Product> products = productRepository.findAll(sort);
        products.forEach(System.out::println);

    }

    @Test
    void sortingWithMultipleFields(){
        String sortBy = "name";
        String sortByDesc = "description";
        String sortDir = "desc";

        Sort sortByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Sort sortByDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortByDesc).ascending() : Sort.by(sortByDesc).descending();

        Sort groupBySort = sortByName.and(sortByDescription);

        List<Product> products = productRepository.findAll(groupBySort);

        products.forEach(System.out::println);

    }

    @Test
    void paginationAndSortingTogether(){

        String sortBy = "price";
        String sortDir = "desc";
        int pageNo = 0;
        int pageSize = 5;

        //Sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach(System.out::println);

        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        int numberOfElements = page.getNumberOfElements();
        int size = page.getSize();
        boolean isLast = page.isLast();
        boolean first = page.isFirst();

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("numberOfElements = " + numberOfElements);
        System.out.println("size = " + size);
        System.out.println("isLast = " + isLast);
        System.out.println("first = " + first);

    }

}






