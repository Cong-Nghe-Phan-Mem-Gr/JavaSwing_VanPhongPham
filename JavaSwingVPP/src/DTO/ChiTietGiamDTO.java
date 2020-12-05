/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nam
 */
public class ChiTietGiamDTO {
    private String idMon;
    private String idGiam;
    private String tileGiam;
    public static String layIdGiam;

    public ChiTietGiamDTO(String idMon, String idGiam, String tileGiam) {
        this.idMon = idMon;
        this.idGiam = idGiam;
        this.tileGiam = tileGiam;
    }
    public ChiTietGiamDTO() {
        this.idMon = null;
        this.idGiam = null;
        this.tileGiam = null;
    }

    public String getIdMon() {
        return idMon;
    }

    public String getIdGiam() {
        return idGiam;
    }

    public String getTileGiam() {
        return tileGiam;
    }

    public void setIdMon(String idMon) {
        this.idMon = idMon;
    }

    public void setIdGiam(String idGiam) {
        this.idGiam = idGiam;
    }

    public void setTileGiam(String tileGiam) {
        this.tileGiam = tileGiam;
    }
    
}
