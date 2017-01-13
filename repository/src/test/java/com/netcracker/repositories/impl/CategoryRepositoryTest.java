package com.netcracker.repositories.impl;

import com.netcracker.entities.Category;
import com.netcracker.exception.DuplicateEntityException;
import com.netcracker.exception.NoSuchEntityException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test for {@link com.netcracker.repositories.impl.CategoryRepositoryImpl}
 * <p>
 * Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepositoryImpl categoryRepository;
    Category category = new Category();

    @Test
    public void addCategoryTest() {
        category.setName("TEST");

        long countOfCategoryTableRows = categoryRepository.getColumnCount();
        category = categoryRepository.add(category);

        assertThat(categoryRepository.getColumnCount(), is(countOfCategoryTableRows + 1));
    }

    @Test
    public void updateCategoryTest() {
        category.setName("NEWTEST");

        assertThat(categoryRepository.update(category), is(category));
    }

    @Test
    public void getByIdCategoryTest() {
        assertThat(categoryRepository.getById(category.getId()), is(category));
    }

    @Test
    public void deleteCategoryTest() {
        long countOfCategoryTableRows = categoryRepository.getColumnCount();
        categoryRepository.remove(category);

        assertThat(categoryRepository.getColumnCount(), is(countOfCategoryTableRows - 1));
    }

    @Test(expected = DuplicateEntityException.class)
    public void addDuplicateCategoryThrowsException() {

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingCategoryThrowsException() {

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingCategoryThrowsException() {

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingCategoryThrowsException() {

    }

}
