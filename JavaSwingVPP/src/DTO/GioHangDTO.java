
package DTO;

public class GioHangDTO {
    public String idsp,tensp;
    public int sl,dongia,thanhtien,tonkho;
    public GioHangDTO(){};
    public GioHangDTO(String idsp, String tensp,int tonkho,int dongia, int sl,int thanhtien) {
        this.idsp = idsp;
        this.tensp = tensp;
        this.tonkho = tonkho;
        this.sl = sl;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public int getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(int thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public int getTonkho() {
        return tonkho;
    }

    public void setTonkho(int tonkho) {
        this.tonkho = tonkho;
    }

    public String getIdsp() {
        return idsp;
    }

    public void setIdsp(String idsp) {
        this.idsp = idsp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int thanhTien(){
        return this.thanhtien = sl*dongia;
    }
}
