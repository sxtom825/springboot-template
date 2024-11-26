package com.example.demo.util;


import java.io.IOException;

public class Test2 {

    public record Customer(String id, String name, PhoneNumber phoneNumber, Address address) {

    }

    public record PhoneNumber(String areaCode, String number) {
    }

    public record Address(String city, String address, String zipCode) {
    }


    public static void main(String[] args) {

        try {
            processLines();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void processLines() throws IOException {
        String path = "/Users/song/Desktop/cache/doc/idea/untitled/out/production/untitled/com/";


    }

}
