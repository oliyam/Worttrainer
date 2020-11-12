package WorttrainerView;

/**
 *@author oli
 *@version 29.05.2019
 *
 * Layout Klasse für VieleLayouts
 */

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class MainLayoutPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private ImagePanel image=new ImagePanel();
	@SuppressWarnings("unused")
	private JButton reset,save,next,add;
	
	public MainLayoutPanel(AbstractAction action) {
	    
	    setLayout(new BorderLayout());
	    JPanel grid_bottom=new JPanel(new GridLayout(3,3));
	    JPanel grid_save=new JPanel(new GridLayout(0,2));
	    grid_save.add(new JTextField("Pfad"));
	    	    
	    grid_bottom.add(new JLabel("Richtige Wörter:"));
	    grid_bottom.add(new JLabel("0"));
	    
	    reset = new JButton("Zurücksetzen");
	    reset.addActionListener(action);
	    grid_bottom.add(reset);
	    
	    grid_bottom.add(new JLabel("Anzahl Wörter:"));
	    grid_bottom.add(new JLabel("0"));
	    
	    add = new JButton("Wort hinzufügen");
	    add.addActionListener(action);
	    grid_bottom.add(add);
	    
	    save = new JButton("Speichern");
	    save.addActionListener(action);
	    grid_bottom.add(save);
	    grid_bottom.add(grid_save);
	    add(grid_bottom, BorderLayout.PAGE_END);
	    JPanel grid_top=new JPanel(new GridLayout(2,0));
	    grid_top.add(new JLabel("Richtige Wörter:"));
	    grid_top.add(new JTextField());
	    add(grid_top, BorderLayout.PAGE_START);

	    image.setImage("https://www.w3schools.com/w3css/img_lights.jpg");
	    add(image, BorderLayout.CENTER);
	}
	
	public void setImage(String url) {
	    image.setImage(url);
	}
	
	@SuppressWarnings("serial")
	class ImagePanel extends JPanel{
	
            private BufferedImage img;
            
            public void setImage(String url) {
        	new Thread(()->{
                    img = new BufferedImage(1920, 1080, BufferedImage.TYPE_INT_ARGB);
                    try { 
            	    	img = ImageIO.read(new URL(url)); 
            	    	repaint();
                    }
                    catch (IOException e) { }  
        	}).start();
            }
            
            public void paintComponent(Graphics g) {
            	g.fillRect(0,0,getWidth(),getHeight());      	        
            	if(img!=null) {
                	float
                	x=img.getWidth(),y=img.getHeight(),
                	x_=getWidth(),y_=getHeight(),
                	r=x/y;
                	if(x>y){x=x_;}else{y=y_;}               	
                	if(x>=x_) {
                	    y=x_/r;
                	    x=x_;
                	}        
                	if(y>=y_) {
                	    x=y_*r;
                	    y=y_;
                	}
                	g.drawImage(img,(int)((x_-x)/2),(int)((y_-y)/2),(int)x,(int)y,null);
            	}
            }
	}
}
