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
public class HoadonDTO {
    public String idnv,idhd,idkh,tensp,loaisp,ngaylap,idsp;
    public int dongia,soluong,trangthai,thanhtien,tongtien;

    public HoadonDTO(){
        
    }
    
    public HoadonDTO(String idhd,String idkh,String idnv,String idsp,String tensp,int dongia,int soluong,int thanhtien,int tongtien,String ngaylap,int trangthai){
        setIdnv(idnv);
        setIdkh(idkh);
        setIdhd(idhd);
        setTensp(tensp);
        setIdsp(idsp);
        setGiatien(dongia);
        setSoluong(soluong);
        setNgaylap(ngaylap); 
        setTrangthai(trangthai);
        setThanhtien(thanhtien);
        setTongtien(tongtien);
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setIdsp(String idmon) {
        this.idsp = idmon;
    }

    public String getIdsp() {
        return idsp;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public void setIdhd(String idhd) {
        this.idhd = idhd;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getIdkh() {
        return idkh;
    }

    public void setIdkh(String idkh) {
        this.idkh = idkh;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public String getIdhd() {
        return idhd;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public int getDongia() {
        return dongia;
    }


    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setLoaisp(String loaimonan) {
        this.loaisp = loaimonan;
    }

    public void setGiatien(int giatien) {
        this.dongia = giatien;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getIdnv() {
        return idnv;
    }

    public String getTensp() {
        return tensp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public int getGiatien() {
        return dongia;
    }

    public int getSoluong() {
        return soluong;
    }
    
    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getTongtien() {
        return tongtien;
    }
}
