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
public class nhacungcapDTO 
{
    private String idncc; 
    private String tenncc;  
    private String email;
    private String phone;
    public static String layIdncc;
    
    public nhacungcapDTO(String idncc, String tenncc)
    {
        this.idncc = idncc;
        this.tenncc = tenncc;
        this.email = email;
        this.phone = phone;
    }
    public nhacungcapDTO() 
    {
        this.idncc = idncc;
        this.tenncc = tenncc;
        this.email = email;
        this.phone = phone;
    }

    public String getIdncc() {
        return idncc;
    }

    public void setIdncc(String idncc) {
        this.idncc = idncc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    




    
}
