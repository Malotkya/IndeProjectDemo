package com.alexmalotky.util;

import org.apache.catalina.realm.MessageDigestCredentialHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.NoSuchAlgorithmException;

public class PasswordManager {

    private static final Logger logger = LogManager.getLogger(PasswordManager.class);

    public static String hash(String password) {
        MessageDigestCredentialHandler credentialHandler = new MessageDigestCredentialHandler();

        try {
            credentialHandler.setAlgorithm("sha-256");
        } catch (NoSuchAlgorithmException e) {
            logger.debug(e);
        }

        credentialHandler.setEncoding("UTF-8");
        return credentialHandler.mutate(password);
    }
}
