/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 *
 * @author HP
 */
public class panel extends JComponent{

    public panel() {
        setOpaque(false);
    }

    // this segment is for the 2D graphics background and shapes 
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setColor(new Color(206, 14, 184));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        int width = getWidth();
        int height = getHeight();
        String boarderString = "49% 51% 80% 20% / 59% 43% 57% 41%";
        FancyBorderRadius border = new FancyBorderRadius(width, height, boarderString);
        g2.fill(border.getShape());
        g2.dispose();
        super.paintComponent(g);ug
    }t
    
    
    
    
    
}
