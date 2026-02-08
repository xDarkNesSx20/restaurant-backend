package com.nisapps.restaurant.domain.entities;

import com.nisapps.restaurant.domain.utils.ConfigValue;
import com.nisapps.restaurant.domain.utils.ConfigValueConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "configs")
public class Config {
    @Id
    private String key;

    @Convert(converter = ConfigValueConverter.class)
    private ConfigValue value;
}
