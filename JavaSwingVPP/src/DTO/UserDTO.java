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
public class UserDTO {
    private String username;
    private String pass;
    private String idnv;

    public UserDTO()
    {
        this.username = "";
        this.pass = "";
        this.idnv = "";
    }

    public UserDTO(String username, String pass, String idnv) {
        this.username = username;
        this.pass = pass;
        this.idnv = idnv;
    }

    
    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }
    

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}