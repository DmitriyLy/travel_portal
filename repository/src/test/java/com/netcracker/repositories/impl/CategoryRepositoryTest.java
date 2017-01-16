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
    private CategoryRepositoryImpl categoryRepository;

    @Test
    public void addCategoryTest() {
        /*Category category = new Category();
        category.setName("TEST");
        long countOfCategoryTableRows = categoryRepository.getColumnCount();
        categoryRepository.add(category);

        assertThat(categoryRepository.getColumnCount(), is(countOfCategoryTableRows + 1));*/
    }

    @Test
    public void deleteCategoryTest() {
        /*Category category = new Category();
        category.setId(1);
        category.setName("DELTEST");
        long countOfCategoryTableRows = categoryRepository.getColumnCount();
        categoryRepository.remove(category);

        assertThat(categoryRepository.getColumnCount(), is(countOfCategoryTableRows - 1));*/
    }

    @Test
    public void getByIdCategoryTest() {
        /*Category category = categoryRepository.getById(2);

        assertThat(category.getId(), is(2));
        assertThat(category.getName(), is("GETTEST"));*/
    }

    @Test
    public void updateCategoryTest() {
        /*Category category = new Category();
        category.setId(1);
        category.setName("NEWTEST");

        assertThat(categoryRepository.update(category), is(category));*/
    }

    /*@Test(expected = DuplicateEntityException.class)
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

    }*/

}
