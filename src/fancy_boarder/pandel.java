
package fancy_boarder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JComponent;
import swings.FancyBorderRadius;

/**
 *
 * @author HP
 */

// no need ;)
public class pandel extends JComponent{

    private Icon icon;
    private BufferedImage buff;
    
    public pandel() {
        setOpaque(false);
        //very important
        
    }
    
private void createimage (){
        
}
//next i save this on my github :)))))
    //Bye from Sammy ))
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(11, 14, 100));
        int width = getWidth();
        int height = getHeight();
        String border = "48% 52% 56% 44% / 52% 36% 64% 48% ";
        FancyBorderRadius radius = new FancyBorderRadius(width, height, border);
        g2.fill(radius.getShape());
        g2.dispose();
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
 // and we are done for the shape :)
    }
    
    
}
