package com.netcracker.repositories.impl;

import com.netcracker.entities.Comment;
import com.netcracker.exception.DuplicateEntityException;
import com.netcracker.exception.NoSuchEntityException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *  Test for {@link com.netcracker.repositories.impl.UserRepositoryImpl}
 *
 *  Add a VM Options before start test:
 * -Duser.language=en
 * -Duser.region=us
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class CommentRepositoryTest {

    /*

    @Autowired
    CommentRepositoryImpl commentRepository;
    Comment comment = new Comment();

    @Test
    public void addCommentTest(){
        comment.setUserId(1);
        comment.setLabelId(1);
        comment.setCommentDate(new Date());
        comment.setCommentText("TEST");

        long countOfCommentTableRows = commentRepository.getColumnCount();
        comment = commentRepository.add(comment);

        assertThat(commentRepository.getColumnCount(), is(countOfCommentTableRows + 1));
    }

    @Test
    public void updateCommentTest(){
        comment.setCommentText("NEWTEST");

        assertThat(commentRepository.update(comment), is(comment));
    }

    @Test
    public void getByIdCommentTest(){
        assertThat(commentRepository.getById(comment.getId()), is(comment));
    }

    @Test
    public void deleteCommentTest(){
        long countOfCommentTableRows = commentRepository.getColumnCount();
        commentRepository.remove(comment);

        assertThat(commentRepository.getColumnCount(), is(countOfCommentTableRows - 1));
    }

    @Test(expected = DuplicateEntityException.class)
    public void addDuplicateCommentThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingCommentThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingCommentThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingCommentThrowsException(){

    }

    */
}
