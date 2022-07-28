package com.flatex.watergate.lombok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class AccountTest {

    @Test
    void testImmutability() {
        Account account = Account.builder()
                .id(1234)
                .type("test")
                .currency("EUR")
                .createdDate(LocalDateTime.now())
                .build();

        Assertions.assertNotNull(account);
    }


    @Test
    void testImmutabilityWithCollection() {
        List<Entry> entries = new ArrayList<>();
        entries.add(Entry.builder().id(789).amount(100.0).build());
        Account account = Account.builder()
                .id(1234)
                .type("test")
                .currency("EUR")
                .createdDate(LocalDateTime.now())
                .entries(List.of())
                .build();

        Assertions.assertNotNull(account);
        Assertions.assertEquals(1, account.getEntries().size());

        account.getEntries().add(Entry.builder().build());
        Assertions.assertEquals(2, account.getEntries().size());

    }
}
