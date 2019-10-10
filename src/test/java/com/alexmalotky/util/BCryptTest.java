package com.alexmalotky.util;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.jupiter.api.Assertions.*;
import static org.mindrot.jbcrypt.BCrypt.*;

public class BCryptTest {

    @Test
    public void testHashing() {
        String password = "12345";
        String salt = gensalt();

        String hash = hashpw(password, salt);
        assertTrue(checkpw(password, hash));

        System.out.println(hash);
    }
}
