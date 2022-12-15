
package fancy_boarder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import swings.FancyBorderRadius;

public class panel extends JComponent{

    public panel() {
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        int width = getWidth();
        int height = getHeight();
        String borderValue = "49% 51% 80% 20% / 50% 59% 41% 50%";
        FancyBorderRadius radius = new FancyBorderRadius(width, height, borderValue);
        g2.setColor((new Color(124,124,233)));
        g2.fill(radius.getShape());
        g2.dispose();
        super.paintComponent(g); 
    }
    
    
    
}
