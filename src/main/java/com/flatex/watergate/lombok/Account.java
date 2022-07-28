package com.flatex.watergate.lombok;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class Account {
    private int id;
    private String type;
    private String currency;
    private LocalDateTime createdDate;
    private List<Entry> entries;
}
