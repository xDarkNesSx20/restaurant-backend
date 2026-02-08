package com.nisapps.restaurant.domain.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConfigValue {
    private Object value;
    private ValueType type;
}
