
package fancy_boarder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import swings.FancyBorderRadius;

/**
 *
 * @author HP
 */

// no need ;)
public class pandel extends JComponent{

    private  BufferedImage buffered;
    private Icon image; 
    
    public pandel() {
        setOpaque(false);
        //very important
    image = new ImageIcon(getClass().getResource("/image/pack/picture.jpg"));
  
}
    
private void CreateImage (){
    if (image != null) {
        int width = getWidth();
        int height = getHeight();
        if (width> 0 && height >0) {
            buffered  = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = buffered.createGraphics();
            Rectangle rec = getAutoSize(image);
            g2.drawImage(((ImageIcon)image).getImage(), rec.x,rec.y,rec.width,rec.height, null);
           
            g2.dispose();
            
        }
        
    }
    
}

private Rectangle getAutoSize(Icon image) {
        int w = getWidth();
        int h = getHeight();
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int x = (w - width) / 2;
        int y = (h - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
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
