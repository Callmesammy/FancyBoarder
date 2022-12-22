
package swings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author HP
 */
public class Panel extends  JComponent{

    private BufferedImage buffered;
    private Icon image;
    
    public Panel() {
        image = new ImageIcon(getClass().getResource("/image/pack/picture.jpg"));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        int width = getWidth();
        int height = getHeight();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        String str = "48% 52% 56% 44% / 52% 49% 51% 48% ";
        FancyBorderRadius fan = new FancyBorderRadius(width, height, str);
        
        g2.setColor(new Color(150,112,170));
        g2.fill(fan.getShape());
        g2.dispose();
        
        super.paintComponent(g); 
    }
    
    
}
