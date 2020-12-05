/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.ComboBoxList;
import java.awt.Component;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class ComboBoxRender extends JLabel implements ListCellRenderer{
    
    public ComboBoxRender(){
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }
    
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        ComboBoxList cbl =(ComboBoxList)value;//get values
        
        setIcon(cbl.getImg());//set values
        setText(cbl.getName());
        
        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }else{
            setBackground(getBackground());
            setForeground(getForeground());
        }
        
        return this;
    }

    
}
