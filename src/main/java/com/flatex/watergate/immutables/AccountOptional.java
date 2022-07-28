package com.flatex.watergate.immutables;

import org.immutables.value.Value;
import org.immutables.value.internal.$processor$.meta.$ValueMirrors;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Optional attributes
 * Default attributes
 * Naming PO
 */
@Value.Immutable
@Value.Style(typeImmutable = "Watergate*")
public abstract class AccountOptional {

    abstract int id();
    abstract Optional<String> type();
    abstract Optional<String> currency();
    @Value.Default
    LocalDateTime createdDate() { return LocalDateTime.now(); }
}
