package com.onlinestore.music;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseClass {

    private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);

    @Before
    public void setUp() {
        logger.info("Running Setup");
    }

    @After
    public void tearDown() {
        logger.info("Running Teardown");
    }
}
