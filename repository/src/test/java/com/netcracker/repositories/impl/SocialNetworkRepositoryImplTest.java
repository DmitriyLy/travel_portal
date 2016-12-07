package com.netcracker.repositories.impl;

import com.netcracker.entities.SocialNetwork;
import com.netcracker.specifications.impl.SocialNetworksByName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
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
    public void addTestSocialNetwork() {
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setName("Keep in touch lolka");

        List<SocialNetwork> beforeList = socialNetworkRepository.query(new SocialNetworksByName("Keep in touch lolka"));
        socialNetworkRepository.add(socialNetwork);
        List<SocialNetwork> afterList = socialNetworkRepository.query(new SocialNetworksByName("Keep in touch lolka"));

        assertTrue((afterList.size() - beforeList.size()) == 1);
    }

    @Test
    public void updateTestSocialNetwork() {
        /*SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.setName("test1");
        socialNetworkRepository.add(socialNetwork);

        List<SocialNetwork> name1BeforeList = socialNetworkRepository.query(new SocialNetworksByName("test1"));
        List<SocialNetwork> name2BeforeList = socialNetworkRepository.query(new SocialNetworksByName("test2"));

        socialNetwork.setName("test2");
        socialNetworkRepository.update(socialNetwork);

        List<SocialNetwork> name1AfterList = socialNetworkRepository.query(new SocialNetworksByName("test1"));
        List<SocialNetwork> name2AfterList = socialNetworkRepository.query(new SocialNetworksByName("test2"));

        assertEquals(1, name1BeforeList.size() - name1AfterList.size());
        assertEquals(1,name2AfterList.size() - name2BeforeList.size());*/
    }

}
