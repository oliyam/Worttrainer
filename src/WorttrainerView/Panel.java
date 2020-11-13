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

@SuppressWarnings("serial")
public class Panel extends JPanel{

	private ImagePanel image=new ImagePanel();
	private JButton reset,save,add;
	private JTextField input,path;
	private JLabel correct_words,total_words;
	
	public Panel(AbstractAction action) {
	    
	    setLayout(new BorderLayout());
	    JPanel grid_bottom = new JPanel(new GridLayout(3,3));
	    JPanel grid_save = new JPanel(new GridLayout(0,2));
	    path = new JTextField("Pfad");
	    grid_save.add(path);
	    	    
	    grid_bottom.add(new JLabel("Richtige Wörter:"));
	    correct_words = new JLabel("0");
	    grid_bottom.add(correct_words);
	    
	    reset = new JButton("Zurücksetzen");
	    reset.addActionListener(action);
	    grid_bottom.add(reset);
	    
	    grid_bottom.add(new JLabel("Anzahl Wörter:"));
	    total_words = new JLabel("0");
	    grid_bottom.add(total_words);
	    
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
	    input = new JTextField();
	    input.addActionListener(action);
	    grid_top.add(input);
	    add(grid_top, BorderLayout.PAGE_START);

	    add(image, BorderLayout.CENTER);
	    
	}
	
	public void setImage(String url) {
	    image.setImage(url);
	}
	
	public void setTextInput(String text) {
	    input.setText(text);
	}
	
	public void setCorrectWords(int i) {
	    correct_words.setText(""+i);
	}
	
	public void setTotalWords(int i) {
	    total_words.setText(""+i);
	}
	
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
