package com.alexmalotky.util;

import org.apache.catalina.CredentialHandler;
import org.apache.catalina.Globals;
import org.apache.catalina.realm.MessageDigestCredentialHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class EncryptionTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    public void testPasswordHash() {
        String stringToHash = "12345";
        MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();

        try {
            credentialHandler.setAlgorithm("sha-256");
        } catch (NoSuchAlgorithmException e) {
            logger.debug(e);
        }
        credentialHandler.setEncoding("UTF-8");
        String hashedPassword = credentialHandler.mutate(stringToHash);

        logger.debug(hashedPassword);
    }
}
