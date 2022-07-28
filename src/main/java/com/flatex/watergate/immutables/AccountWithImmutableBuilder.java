package com.flatex.watergate.immutables;

import org.immutables.value.Value;

import java.time.LocalDateTime;

/**
 * Default Implementation with Immutable Builder
 */
@Value.Immutable
@Value.Style(strictBuilder = true)
public abstract class AccountWithImmutableBuilder {

    abstract int getId();
    abstract String getType();
    abstract String getCurrency();
    abstract LocalDateTime getCreatedDate();

}
