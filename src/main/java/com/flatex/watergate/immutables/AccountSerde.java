package com.flatex.watergate.immutables;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.time.LocalDateTime;

@Value.Immutable
@Value.Style(privateNoargConstructor = true)
@JsonSerialize(as = ImmutableAccountSerde.class)
@JsonDeserialize(as = ImmutableAccountSerde.class)
public abstract class AccountSerde {

    abstract int id();
    @JsonProperty("account_type")
    abstract String type();
    @Value.Default
    String currency() { return "EUR";}
    @Value.Default
    LocalDateTime createdDate() { return LocalDateTime.now();}
}
