package ru.mts.homework.model;

import lombok.Data;

import java.util.Map;

@Data
public class ServiceResponse {

    private String id;

    private String serviceCode;

    private String messageCode;

    private Map<String, Object> variables;

}
