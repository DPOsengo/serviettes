package com.bigcorp.booking.pojo;

public class NumPojo {
    private static int compteur;
    private long nombreAleatoire;

    public NumPojo() {
        this.nombreAleatoire = (long) (Math.random() * Math.pow(10, 12));
        this.compteur = 999;
    }

    public Integer getCompteur() {
        return compteur;
    }

    public void setCompteur(Integer compteur) {
        NumPojo.compteur = compteur;
    }

    public long getNombreAleatoire() {
        return nombreAleatoire;
    }

    public void setNombreAleatoire(long nombreAleatoire) {
        this.nombreAleatoire = nombreAleatoire;
    }

    public void decrementerCompteur(){
        this.compteur--;
    }
}
