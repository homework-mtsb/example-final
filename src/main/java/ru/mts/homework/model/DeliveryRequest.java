package ru.mts.homework.model;

import lombok.Data;

@Data
public class DeliveryRequest extends ServiceRequest {

    private String address;

    private String deliveryType;

    private String clientPhone;

}
