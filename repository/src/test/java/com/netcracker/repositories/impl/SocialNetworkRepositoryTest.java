package com.netcracker.repositories.impl;

import com.netcracker.entities.SocialNetwork;
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
public class SocialNetworkRepositoryTest {

    @Autowired
    SocialNetworkRepositoryImpl socialNetworkRepository;
    SocialNetwork socialNetwork = new SocialNetwork();

    @Test
    public void addSocialNetworkTest(){
        socialNetwork.setName("TEST");

        long countOfSocialNetworkTableRows = socialNetworkRepository.getColumnCount();
        socialNetwork = socialNetworkRepository.add(socialNetwork);

        assertThat(socialNetworkRepository.getColumnCount(), is(countOfSocialNetworkTableRows + 1));
    }

    @Test
    public void updateSocialNetworkTest(){
        socialNetwork.setName("NEWTEST");

        assertThat(socialNetworkRepository.update(socialNetwork), is(socialNetwork));
    }

    @Test
    public void getByIdSocialNetworkTest(){
        assertThat(socialNetworkRepository.getById(socialNetwork.getId()), is(socialNetwork));
    }

    @Test
    public void deleteSocialNetworkTest(){
        long countOfSocialNetworkTableRows = socialNetworkRepository.getColumnCount();
        socialNetworkRepository.remove(socialNetwork);

        assertThat(socialNetworkRepository.getColumnCount(), is(countOfSocialNetworkTableRows - 1));
    }

    @Test(expected = DuplicateEntityException.class)
    public void addDuplicateSocialNetworkThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void updateNonExistingSocialNetworkThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void getNonExistingSocialNetworkThrowsException(){

    }

    @Test(expected = NoSuchEntityException.class)
    public void deleteNonExistingSocialNetworkThrowsException(){

    }

}
