package com.flatex.watergate.immutables;

import org.immutables.value.Value;

import java.time.LocalDateTime;

/**
 * Constructor approach
 */
@Value.Immutable
public abstract class AccountConstructor {

    @Value.Parameter
    abstract int getId();
    @Value.Parameter
    abstract String getType();
    @Value.Parameter
    abstract String getCurrency();
    @Value.Parameter
    abstract LocalDateTime getCreatedDate();
}
