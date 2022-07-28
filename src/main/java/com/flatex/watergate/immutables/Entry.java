package com.flatex.watergate.immutables;

import org.immutables.value.Value;
import org.immutables.value.internal.$processor$.meta.$ValueMirrors;

@Value.Immutable
public abstract class Entry {

    abstract int getId();
    abstract double getAmount();
}
