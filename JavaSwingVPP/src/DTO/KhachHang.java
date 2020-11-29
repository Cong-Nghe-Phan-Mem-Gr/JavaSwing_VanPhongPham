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
public class KhachHang {
    private String idKh, ho, ten, email, sdt, gioitinh;
    private double tongtiendamua;
    private int trangthai;
    public KhachHang(){}
    public KhachHang(String idKh, String ho, String ten, String email, String sdt, String gioitinh, double tongtiendamua) {
        this.idKh = idKh;
        this.ho = ho;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.tongtiendamua = tongtiendamua;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getIdKh() {
        return idKh;
    }

    public void setIdKh(String idKh) {
        this.idKh = idKh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public double getTongtiendamua() {
        return tongtiendamua;
    }

    public void setTongtiendamua(double tongtiendamua) {
        this.tongtiendamua = tongtiendamua;
    }
    
    
}
