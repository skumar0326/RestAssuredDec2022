package com.api.pojo;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value ={"default"})

public class Employee {

    private int id;
    @Setter
    private String first_name;
    private String last_name;
    private  String email;
    private List<String> foods;
    private Jobs jobs;


}
