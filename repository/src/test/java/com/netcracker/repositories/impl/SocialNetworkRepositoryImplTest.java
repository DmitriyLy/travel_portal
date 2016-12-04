package com.netcracker.repositories.impl;

import com.netcracker.entities.SocialNetwork;
import com.netcracker.specifications.impl.SocialNetworksByName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by logariett on 03.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/data-context.xml"})
public class SocialNetworkRepositoryImplTest {
    @Autowired
    private SocialNetworkRepositoryImpl socialNetworkRepository;

    @Test
    public void addTestSocialNetworkTest() {
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setName("Keep in touch");

        List<SocialNetwork> beforeList = socialNetworkRepository.query(new SocialNetworksByName("Keep in touch lolka"));
        socialNetworkRepository.add(socialNetwork);
        List<SocialNetwork> afterList = socialNetworkRepository.query(new SocialNetworksByName("Keep in touch lolka"));

        assertTrue((afterList.size() - beforeList.size()) == 1);
    }

}
