/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import javax.swing.Icon;

/**
 *
 * @author USER
 */
public class ComboBoxList{
   private Icon img;
   private String name;
   
   public ComboBoxList(Icon img,String name){
       setImg(img);
       setName(name);
   };

    public void setImg(Icon img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getImg() {
        return img;
    }

    public String getName() {
        return name;
    } 
}
