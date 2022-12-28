/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swings;

import java.awt.AlphaComposite;
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
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author HP
 */

// no comments for now :)
public class panel extends JComponent{

    private Icon image;
    private float minate;
    private Animator animate;
    private FancyAnimation fancy;
    
            // Bye for now :))
    public panel() {
        image = new ImageIcon(getClass().getResource("/image/pack/picture.jpg"));
        init();
    }
    
    private void init(){
        String start = "40% 60% 60% 40% / 60% 30% 70% 40%";
        String end = "40% 60%";
        fancy = new FancyAnimation(start, end);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                minate = fraction;
                repaint();
            }
        
        };
        animate = new Animator(1000, target);
        animate.setResolution(0);
        animate.setAcceleration(0.55f);
        animate.setDeceleration(0.5f);
        animate.setRepeatCount(-1);
        animate.setRepeatBehavior(Animator.RepeatBehavior.REVERSE);
    }

    @Override
    protected void paintComponent(Graphics g) {
    
        int width = getWidth();
        int height = getHeight();
        int x =0;
        int y =0;
        
        String boarderShape = "48% 52% 56% 44% / 52% 43% 57% 48% ";
        FancyBorderRadius fan = new FancyBorderRadius(width, height, boarderShape);
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.fill(fan.getShape());
        if (image != null) {
            g2.setComposite(AlphaComposite.SrcIn);
            Rectangle rec = getAutoSize(image);
            g2.drawImage(toImage(image), rec.x, rec.y, rec.width, rec.height, null);
            
        }
        g2.dispose();
        g.drawImage(img, 0,0,null);
        super.paintComponent(g); 
    
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
    
}
