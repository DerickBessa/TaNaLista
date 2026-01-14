package io.github.TaNaLista.tanalista.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "locals")
public class Local {

    // =========================
    // ATRIBUTOS
    // =========================

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String address;

    private double latitude;
    private double longitude;
    private String linkGoogleMaps;

    // =========================
    // CONSTRUTORES
    // =========================

    protected Local() {
    }

    public Local(String address, double latitude, double longitude, String linkGoogleMaps) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.linkGoogleMaps = linkGoogleMaps;
    }

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getLinkGoogleMaps() {
        return linkGoogleMaps;
    }
}
