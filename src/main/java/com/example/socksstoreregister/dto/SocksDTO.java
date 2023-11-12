package com.example.socksstoreregister.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocksDTO {

    private String color;
    @Min(value = 0)
    @Max(value = 100)
    private Integer cottonPart;
    @Min(value = 1)
    private Integer quantity;
}
