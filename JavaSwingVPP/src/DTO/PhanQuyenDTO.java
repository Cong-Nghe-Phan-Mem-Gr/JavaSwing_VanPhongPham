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
public class PhanQuyenDTO {
    public int idquyenhan;
    public String currentUser;
    public String tenquyen;
    
    public PhanQuyenDTO()
    {
        this.idquyenhan = 0;
        this.currentUser = null;
        this.tenquyen = null;
    }
    public PhanQuyenDTO(int idquyenhan, String currentUser, String tenquyen) {
        this.idquyenhan = idquyenhan;
        this.currentUser = currentUser;
        this.tenquyen = tenquyen;
    }

    public int getIdquyenhan() {
        return idquyenhan;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public String getTenquyen() {
        return tenquyen;
    }

    public void setIdquyenhan(int idquyenhan) {
        this.idquyenhan = idquyenhan;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }
    
}
