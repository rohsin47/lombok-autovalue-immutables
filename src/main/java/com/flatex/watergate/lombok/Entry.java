package com.flatex.watergate.lombok;

import lombok.Builder;
import org.immutables.value.Value;

@Value
@Builder
public class Entry {

    int id;
    double amount;
}
