package com.crud.tasks.config;

import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TrelloConfig.class)
public class TrelloConfigTestSuite {

    @Autowired
    private TrelloConfig trelloConfig;

    @Value("${trello.app.key}")
    String theKey;

    @Value("${trello.username}")
    String theName;

    @Value("${trello.app.token}")
    String theToken;

    @Value("${trello.api.endpoint.prod}")
    String theEndpoint;

    @Test
    public void testMyName() {

        assertEquals(theName, trelloConfig.getTrelloUsername());
    }

    @Test
    public void testMyKey() {

        assertEquals(theKey, trelloConfig.getTrelloAppKey());
    }

    @Test
    public void testMyToken() {

        assertEquals(theToken, trelloConfig.getTrelloToken());
    }

    @Test
    public void testMyEndpoint() {

        assertEquals(theEndpoint, trelloConfig.getTrelloApiEndpoint());
    }
}
