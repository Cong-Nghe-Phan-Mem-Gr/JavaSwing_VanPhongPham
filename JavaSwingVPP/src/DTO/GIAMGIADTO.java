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
public class ChuongTrinhGiamDTO {
    private String idgiam;
    private String tenchuongtrinh;
    private String thoigianbatdau;
    private String thoigianketthuc;
    private String noidung;
    public ChuongTrinhGiamDTO()
    {
        this.idgiam = null;        
        this.tenchuongtrinh = null;
        this.thoigianbatdau = null;
        this.thoigianketthuc = null;
        this.noidung = null;
    }

    public ChuongTrinhGiamDTO(String idgiam, String tenchuongtrinh, String thoigianbatdau, String thoigianketthuc, String noidung) {
        this.idgiam = idgiam;
        this.tenchuongtrinh = tenchuongtrinh;
        this.thoigianbatdau = thoigianbatdau;
        this.thoigianketthuc = thoigianketthuc;
        this.noidung = noidung;
    }

    public String getIdgiam() {
        return idgiam;
    }

    public String getTenchuongtrinh() {
        return tenchuongtrinh;
    }

    public String getThoigianbatdau() {
        return thoigianbatdau;
    }

    public String getThoigianketthuc() {
        return thoigianketthuc;
    }

    public String getNoidung() {
        return noidung;
    }

    

    public void setIdgiam(String idgiam) {
        this.idgiam = idgiam;
    }

    public void setTenchuongtrinh(String tenchuongtrinh) {
        this.tenchuongtrinh = tenchuongtrinh;
    }

    public void setThoigianbatdau(String thoigianbatdau) {
        this.thoigianbatdau = thoigianbatdau;
    }

    public void setThoigianketthuc(String thoigianketthuc) {
        this.thoigianketthuc = thoigianketthuc;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    
}
