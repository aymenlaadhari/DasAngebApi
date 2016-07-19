/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dastex.jersey.quik.start.model;

/**
 *
 * @author aladhari
 */
public class ImageArtikel {
    private String beschreibung="", url="",textAktiv = "";

    public ImageArtikel() {
    }

    public ImageArtikel(String url, String besch) {
        this.beschreibung = besch;
        this.url = url;
              
    }

    public String getTextAktiv() {
        return textAktiv;
    }

    public void setTextAktiv(String textAktiv) {
        this.textAktiv = textAktiv;
    }

    
    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
