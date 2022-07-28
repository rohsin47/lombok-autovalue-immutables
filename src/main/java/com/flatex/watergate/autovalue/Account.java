package com.flatex.watergate.autovalue;

import com.google.auto.value.AutoValue;

import java.time.LocalDateTime;

@AutoValue
public abstract class Account {

    public abstract int id();
    public abstract String type();
    public abstract String currency();
    public abstract LocalDateTime createdDate();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setId(int id);
        public abstract Builder setType(String type);
        public abstract Builder setCurrency(String currency);
        public abstract Builder setCreatedDate(LocalDateTime createdDate);
        public abstract Account build();
    }
}
