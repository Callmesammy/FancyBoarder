
package swings;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

//Thanks ;))))))))))
public class panel extends JComponent{

    /**
     * @return the image
     */
    public Icon getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Icon image) {
        this.image = image;
        repaint();
    }

    // we create animation :)
    private Icon image; 
    
    private Animator animate;
    private float minate;
   
    // next we create a 360 degree rotaton on the image :)
    
    private Animator minator;
    private float min;
    
    // next we create a start and stop option ;)
    public panel() {
        image = new ImageIcon(getClass().getResource("/image/pack/picture.jpg"));
        init();
    }
    
    private void init(){
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
               minate = fraction;
               repaint();
              }
            
        
        };
        animate = new Animator(5000, target);
        animate.setResolution(5);
        animate.setRepeatCount(-1);
        animate.setRepeatBehavior(Animator.RepeatBehavior.REVERSE);
       
        
        
         TimingTarget targe = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
               min = fraction;
               repaint();
                         }
            
        
        };
        minator = new Animator(10000, targe);
        minator.setResolution(5);
        minator.setRepeatCount(-1);
        minator.setRepeatBehavior(Animator.RepeatBehavior.LOOP);
       
    }
    
    public void start(){
        if (!animate.isRunning()) {
            animate.start();
            minator.start();
            
        }
    }
    public  void stop(){
        animate.stop();
        minator.stop();
    }

    @Override
    protected void paintComponent(Graphics g) {
     
        double width = getWidth()*0.8f;
        double height = getHeight()*0.8f;
        double x = (getWidth()-width)/2;
        double y = (getHeight()-height)/2;
        String start = "40% 60% 60% 40% / 60% 30% 70% 40%";
        String end = "40% 60%";
        FancyAnimation ani = new FancyAnimation(start, end);
        BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        FancyBorderRadius fan = new FancyBorderRadius(width, height, ani.getAnimate(minate));
        
        // for smootness of the lines 
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // for smootness of the image
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setColor(new Color(45, 5, 51));
        // next lets bring the image to same shape with the image ;)
        
        AffineTransform tran = g2.getTransform();
        g2.translate(x, y);
        g2.rotate(Math.toRadians(360*min), width/2, height/2);
        
        
       
        g2.fill(fan.getShape());
        if (getImage() != null) {
            g2.setTransform(tran);
             g2.setComposite(AlphaComposite.SrcIn);
            Rectangle rec = getAutoSize(getImage());
            g2.drawImage(toImage(getImage()), rec.x, rec.y, rec.width, rec.height, null);
        }  g2.dispose();
        g2.dispose();
        g.drawImage(img, 0, 0, null);
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
