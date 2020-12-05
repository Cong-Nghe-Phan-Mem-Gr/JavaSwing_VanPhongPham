/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author USER
 */
public class SanphamDTO {
    public String idsp,tensp,trangthai,cogiamgia,tenloai,loai;
    public int idloai,tonkho,soluongdaban,dongia;

    public SanphamDTO(){}
    public SanphamDTO(String idsp,String tensp,int idloai,String tenloai,int dongia,int tonkho,String trangthai,String cogiamgia,int soluongdaban){
        setIdmon(idsp);
        setTensp(tensp);
        setIdloai(idloai);
        setDongia(dongia);
        setTenloai(tenloai);
        setTonkho(tonkho);
        setTrangthai(trangthai);
        setCogiamgia(cogiamgia);
        setSoluongdaban(soluongdaban);
    }
    
    public void setSoluongdaban(int soluongdaban) {
        this.soluongdaban = soluongdaban;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public String getCogiamgia() {
        return cogiamgia;
    }

    public int getSoluongdaban() {
        return soluongdaban;
    }
    
    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getDongia() {
        return dongia;
    }
    
    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public void setIdmon(String idmon) {
        this.idsp = idmon;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setIdloai(int idloai) {
        this.idloai = idloai;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public void setCogiamgia(String cogiamgia) {
        this.cogiamgia = cogiamgia;
    }

    public String getIdsp() {
        return idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public int getIdloai() {
        return idloai;
    }

    public int getTonkho() {
        return tonkho;
    }

    public String isTrangthai() {
        return trangthai;
    }

    public String isCogiamgia() {
        return cogiamgia;
    }
}
