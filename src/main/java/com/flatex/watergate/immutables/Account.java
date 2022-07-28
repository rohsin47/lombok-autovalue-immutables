package com.flatex.watergate.immutables;

import org.immutables.value.Value;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Default Implementation
 */
@Value.Immutable
@Value.Style(validationMethod = Value.Style.ValidationMethod.NONE)
@Value.Modifiable
public abstract class Account {

    abstract int getId();
    abstract String getType();
    abstract String getCurrency();
    abstract LocalDateTime getCreatedDate();

}
