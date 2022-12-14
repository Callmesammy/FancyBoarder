
package fancy_boarder;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import swings.FancyBorderRadius;
ty

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
//        int height = getHeight();
//mn        FancyBorderRadius radius = new FancyBorderRadius(width, height, border);
        g2.dispose();
        super.paintComponent(g); 
    }
    
    
    
}
