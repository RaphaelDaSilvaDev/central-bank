package com.raphaelsilva.client;

import java.time.LocalDate;
import java.util.Random;

public class Client {
    private final int id;
    private final String name;
    private final String document;
    private final LocalDate bornAt;

    public Client(String name, String document, LocalDate bornAt) {
        int newId = generateId();
        this.id = newId;
        this.name = name;
        this.document = document;
        this.bornAt = bornAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", bornAt=" + bornAt +
                '}';
    }

    private int generateId(){
        Random random = new Random();

        return random.nextInt(900000) + 1000000;
    }
}
