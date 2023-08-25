package com.epicode.model;

import org.springframework.stereotype.Component;

@Component
public class SondaFactory {
    public Sonda creaSonda(double latitude, double longitude) {
        Sonda sonda = new Sonda();
        sonda.setLatitude(latitude);
        sonda.setLongitude(longitude);
        return sonda;
    }
}
