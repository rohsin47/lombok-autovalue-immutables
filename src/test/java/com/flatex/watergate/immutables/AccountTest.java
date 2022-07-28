package com.flatex.watergate.immutables;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

public class AccountTest {

    @Test
    void testImmutabilityAccount() {
        Account account = ImmutableAccount.builder()
                .id(1234)
                .type(null)
                .currency("EUR")
                .createdDate(LocalDateTime.now())
                .build();

        Assertions.assertNotNull(account);
        Assertions.assertEquals("EUR", account.getCurrency());
    }

    @Test
    void testImmutabilityAccountModifier() {
        Account account = ImmutableAccount.builder()
                .id(1234)
                .type("test")
                .currency("EUR")
                .createdDate(LocalDateTime.now())
                .build();

        Account account1 = ImmutableAccount.builder().from(account).currency("USD").build();

        Assertions.assertNotSame(account1, account);
    }

    @Test
    void testImmutabilityAccountBuilder() {
        ImmutableAccountWithImmutableBuilder.Builder accountWithImmutableBuilder = ImmutableAccountWithImmutableBuilder.builder()
                .id(1234)
                .type("test")
                .currency("EUR")
                .createdDate(LocalDateTime.now());

        accountWithImmutableBuilder.currency("USD").build();

        Assertions.assertNotNull(accountWithImmutableBuilder);
    }

    @Test
    void testImmutabilityRequiredAttributes() {
        AccountWithRequiredAttributes account =  ImmutableAccountWithRequiredAttributes.builder()
                .id(1234)
                .type("test")
                .currency("EUR")
                .createdDate(LocalDateTime.now())
                .build();

        Assertions.assertNotNull(account);
    }

    @Test
    void testImmutabilityConstructor() {
        AccountConstructor account =  ImmutableAccountConstructor.of(1234, "test", "EUR", LocalDateTime.now());
        Assertions.assertNotNull(account);
    }

    @Test
    void testImmutabilityOptionalAndDefault() {
        AccountOptional accountOptional = WatergateAccountOptional.builder()
                .id(3456)
                .type("dev")
                .build();

        Assertions.assertNotNull(accountOptional);
        Assertions.assertTrue(accountOptional.type().isPresent());
        Assertions.assertTrue(accountOptional.currency().isEmpty());
        Assertions.assertNotNull(accountOptional.createdDate());
    }

    @Test
    void testImmutabilityCollection() {
        AccountCollection accountCollection = ImmutableAccountCollection.builder()
                .id(3456)
                .type("dev")
                .currency("EUR")
                .createdDate(LocalDateTime.now())
                .addEntries(ImmutableEntry.builder().id(678).amount(100.0).build())
                .build();

        Assertions.assertNotNull(accountCollection);

        Assertions.assertThrows(IllegalStateException.class, () ->  accountCollection.getEntries().add(ImmutableEntry.builder().build()));
    }

    @Test
    void testImmutabilitySerialization() throws JsonProcessingException {
        // construct
        AccountSerde account = ImmutableAccountSerde.builder()
                .id(1234)
                .type("test")
                .build();

        Assertions.assertNotNull(account);
        Assertions.assertEquals("EUR", account.currency());

        // serialize
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        String json = objectMapper.writeValueAsString(account);
        Assertions.assertNotNull(json);

        // deserialize
        AccountSerde accountSerde = objectMapper.readValue(json, AccountSerde.class);
        Assertions.assertNotNull(accountSerde);
        Assertions.assertEquals(account, accountSerde);
    }


}
