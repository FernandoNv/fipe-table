package com.example.fipetable.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleDTO(
        @JsonAlias("Valor")
        String price,
        @JsonAlias("Marca")
        String brand,
        @JsonAlias("Modelo")
        String model,
        @JsonAlias("AnoModelo")
        Integer dateReleased,
        @JsonAlias("Combustivel")
        String fuelType
) {
}
