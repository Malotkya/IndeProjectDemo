package com.alexmalotky.util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    @Disabled
    void runSQL() {
        Database database = Database.getInstance();
        database.runSQL("test.sql");
    }
}