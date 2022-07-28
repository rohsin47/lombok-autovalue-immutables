package com.flatex.watergate.autovalue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AccountTest {

    @Test
    void testImmutability(){
        Account account = new AutoValue_Account.Builder()
                .setId(3456)
                .setType("test")
                .setCurrency("EUR")
                .setCreatedDate(LocalDateTime.now())
                .build();

        Assertions.assertNotNull(account);
    }
}
