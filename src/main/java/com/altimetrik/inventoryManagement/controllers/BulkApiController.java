package com.altimetrik.inventoryManagement.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.altimetrik.inventoryManagement.controllerInterface.BulkApi;
import com.altimetrik.inventoryManagement.model.Battery;
import com.altimetrik.inventoryManagement.model.Path;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@Controller
public class BulkApiController implements BulkApi {

    private static final Logger log = LoggerFactory.getLogger(BulkApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public BulkApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Battery>> createBulkItem(@ApiParam(value = "bulk item" ,required=true )  @Valid @RequestBody Path body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/xml")) {
            try {
                return new ResponseEntity<List<Battery>>(objectMapper.readValue("<battery>  <batteryId>123</batteryId>  <inventoryId>aeiou</inventoryId>  <batteryTypeId>123</batteryTypeId>  <betteryModel>aeiou</betteryModel>  <batteryWeight>123</batteryWeight>  <batteryManfucturingDate>aeiou</batteryManfucturingDate>  <batteryExpirationDate>aeiou</batteryExpirationDate>  <batteryCreateDate>aeiou</batteryCreateDate>  <batteryLastUpdateDate>aeiou</batteryLastUpdateDate>  <batteryLastChargeDate>aeiou</batteryLastChargeDate>  <batteryChargeDate>aeiou</batteryChargeDate>  <batteryCurrentLocation>aeiou</batteryCurrentLocation>  <batteryStatus>aeiou</batteryStatus>  <vendorId>aeiou</vendorId>  <vehicleBrand>aeiou</vehicleBrand>  <batteryCapacity>aeiou</batteryCapacity>  <batteryBrand>aeiou</batteryBrand>  <voltageOutput>aeiou</voltageOutput>  <vehicleModelName>aeiou</vehicleModelName>  <batteryCost>123</batteryCost></battery>", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/xml", e);
                return new ResponseEntity<List<Battery>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Battery>>(objectMapper.readValue("[ {  \"batteryChargeDate\" : \"batteryChargeDate\",  \"batteryId\" : 0,  \"batteryCost\" : 5,  \"batteryManfucturingDate\" : \"batteryManfucturingDate\",  \"batteryCurrentLocation\" : \"batteryCurrentLocation\",  \"vendorId\" : \"vendorId\",  \"batteryLastUpdateDate\" : \"batteryLastUpdateDate\",  \"batteryWeight\" : 1,  \"vehicleModelName\" : \"vehicleModelName\",  \"betteryModel\" : \"betteryModel\",  \"batteryExpirationDate\" : \"batteryExpirationDate\",  \"batteryTypeId\" : 6,  \"vehicleBrand\" : \"vehicleBrand\",  \"batteryCreateDate\" : \"batteryCreateDate\",  \"batteryStatus\" : \"charged\",  \"inventoryId\" : \"inventoryId\",  \"batteryCapacity\" : \"batteryCapacity\",  \"batteryBrand\" : \"batteryBrand\",  \"batteryLastChargeDate\" : \"batteryLastChargeDate\",  \"voltageOutput\" : \"voltageOutput\"}, {  \"batteryChargeDate\" : \"batteryChargeDate\",  \"batteryId\" : 0,  \"batteryCost\" : 5,  \"batteryManfucturingDate\" : \"batteryManfucturingDate\",  \"batteryCurrentLocation\" : \"batteryCurrentLocation\",  \"vendorId\" : \"vendorId\",  \"batteryLastUpdateDate\" : \"batteryLastUpdateDate\",  \"batteryWeight\" : 1,  \"vehicleModelName\" : \"vehicleModelName\",  \"betteryModel\" : \"betteryModel\",  \"batteryExpirationDate\" : \"batteryExpirationDate\",  \"batteryTypeId\" : 6,  \"vehicleBrand\" : \"vehicleBrand\",  \"batteryCreateDate\" : \"batteryCreateDate\",  \"batteryStatus\" : \"charged\",  \"inventoryId\" : \"inventoryId\",  \"batteryCapacity\" : \"batteryCapacity\",  \"batteryBrand\" : \"batteryBrand\",  \"batteryLastChargeDate\" : \"batteryLastChargeDate\",  \"voltageOutput\" : \"voltageOutput\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Battery>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Battery>>(HttpStatus.NOT_IMPLEMENTED);
    }

}