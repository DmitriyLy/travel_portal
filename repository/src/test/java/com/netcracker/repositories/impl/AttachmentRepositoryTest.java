package com.netcracker.repositories.impl;

import com.netcracker.utils.CleanInsertTestExecutionListener;
import com.netcracker.utils.DataSetLocation;
import com.netcracker.entities.Attachment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *  Test for {@link com.netcracker.repositories.impl.AttachmentRepositoryImpl}
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-data-context.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, CleanInsertTestExecutionListener.class})
@DataSetLocation("classpath:/attachment-dataset.xml")
public class AttachmentRepositoryTest {

    @Autowired
    AttachmentRepositoryImpl repository;

    @Test
    public void add_newAttachment() {
        Attachment expected = repository.add(new Attachment("4", 4, "attach4"));

        assertThat(expected, is(repository.getById(4)));
    }

    @Test
    public void update_firstAttachment() {
        Attachment expected = new Attachment("10", 10, "attach10");
        expected.setId(1);
        repository.update(expected);

        assertThat(expected, is(repository.getById(1)));
    }

    @Test
    public void getById_firstAttachment() {
        Attachment expected = new Attachment("1", 1, "attach1");
        expected.setId(1);

        assertThat(expected, is(repository.getById(1)));
    }

    @Test
    public void remove_firstAttachment() {
        Attachment attachment = new Attachment("1", 1, "attach1");
        attachment.setId(1);
        repository.remove(attachment);

        assertThat(1L, is(repository.getColumnCount()));
    }

    @Test
    public void getColumnCount_twoAttachments() {
        long expected = repository.getColumnCount();

        assertThat(expected, is(2L));
    }

    /*@Test(expected = DuplicateEntityException.class)
    public void addDuplicateAttachmentThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingAttachmentThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingAttachmentThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingAttachmentThrowsException(){

    }*/
}
