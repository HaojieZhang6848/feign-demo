package edu.fudan.feigncommon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {

    private Integer id;

    private String name;

    private String color;

    private String origin;
}
