package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
