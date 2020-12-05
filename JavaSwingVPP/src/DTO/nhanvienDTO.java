/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author MY PC
 */
public class nhanvienDTO 
{
    private String idnv;
    private String fname;
    private String lname;
    private String phone;
    private String email;
    private String address;
    private String loainv, ngaysinh;
    private int luong;
    private String trangthai;
    
    public nhanvienDTO()
    {
        
    }
    
    public nhanvienDTO(String idnv, String fname, String lname, String phone, String email, String address, String loainv, int luong, String trangthai)
    {
        this.idnv = idnv;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.loainv = loainv;
        this.luong = luong;
        this.trangthai = trangthai;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoainv() {
        return loainv;
    }

    public void setLoainv(String loainv) {
        this.loainv = loainv;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
