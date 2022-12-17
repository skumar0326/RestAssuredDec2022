package com.api.pojo;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value ={"default"})

public class Employee {

    private int id;
    private String first_name;
    private String last_name;
    private  String email;
    private List<String> foods;
    private jobs jobs;


}
