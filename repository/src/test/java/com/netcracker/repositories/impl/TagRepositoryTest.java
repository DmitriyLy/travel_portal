package com.netcracker.repositories.impl;

import com.netcracker.entities.Tag;
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
 *  Test for {@link com.netcracker.repositories.impl.UserRepositoryImpl}
 *
 *  Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class TagRepositoryTest {

    @Autowired
    TagRepositoryImpl tagRepository;
    Tag tag = new Tag();

    @Test
    public void addTagTest(){
        tag.setName("TEST");

        long countOfTagTableRows = tagRepository.getColumnCount();
        tag = tagRepository.add(tag);

        assertThat(tagRepository.getColumnCount(), is(countOfTagTableRows + 1));
    }

    @Test
    public void updateTagTest(){
        tag.setName("NEWTEST");

        assertThat(tagRepository.update(tag), is(tag));
    }

    @Test
    public void getByIdTagTest(){
        assertThat(tagRepository.getById(tag.getId()), is(tag));
    }

    @Test
    public void deleteTagTest(){
        long countOfTagTableRows = tagRepository.getColumnCount();
        tagRepository.remove(tag);

        assertThat(tagRepository.getColumnCount(), is(countOfTagTableRows - 1));
    }

    @Test(expected = DuplicateEntityException.class)
    public void addDuplicateTagThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingTagThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingTagThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingTagThrowsException(){

    }

}
