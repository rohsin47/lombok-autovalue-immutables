package com.flatex.watergate.immutables;

import org.immutables.value.Value;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Default Implementation
 */
@Value.Immutable
@Value.Style(jdkOnly = true)
public interface Account {
    int getId();
    String getType();
    String getCurrency();
    LocalDateTime getCreatedDate();
    List<Entry> getEntries();
}
