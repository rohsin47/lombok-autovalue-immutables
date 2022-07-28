package com.flatex.watergate.immutables;

import org.immutables.value.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value.Immutable
public abstract class AccountCollection {

    abstract int getId();
    abstract String getType();
    abstract String getCurrency();
    abstract LocalDateTime getCreatedDate();
    abstract List<Entry> getEntries();
}
