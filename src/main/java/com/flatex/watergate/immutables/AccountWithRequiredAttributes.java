package com.flatex.watergate.immutables;

import org.immutables.value.Value;

import java.time.LocalDateTime;

/**
 * Default Implementation with mandatory attributes
 */
@Value.Immutable
@Value.Style(stagedBuilder = true)
public abstract class AccountWithRequiredAttributes {

    abstract int getId();
    abstract String getType();
    abstract String getCurrency();
    abstract LocalDateTime getCreatedDate();
}
