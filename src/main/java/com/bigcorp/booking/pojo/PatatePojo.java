package com.bigcorp.booking.pojo;

public class PatatePojo {
    String variete;
    int masse;

    public PatatePojo(String variete, int masse) {
        this.variete = variete;
        this.masse = masse;
    }

    public String getVariete() {
        return variete;
    }

    public void setVariete(String variete) {
        this.variete = variete;
    }

    public int getMasse() {
        return masse;
    }

    public void setMasse(int masse) {
        this.masse = masse;
    }
}
