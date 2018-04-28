import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class Paint extends JPanel implements ActionListener {
	
	public static Color change = Color.GREEN;
	
        static rect rect0;
        static rect rect1;
        static rect rect2;
		static rect rect3;
		static rect rect4;
		static rect rect5;
		static rect rect6;
		static rect rect7;
		static rect rect8;
		static rect rect9;
		static rect rectS;
		static rect rectE;
		static rect rectV1;
		static rect rectV2;
        
        public Paint() {
        		
                rect0 = new rect(0, 0, 50, 500,Color.BLACK); // x,y, w,h
                rect1 = new rect(50, 0, 400, 50,Color.BLACK);
                rect2 = new rect(50, 450, 400,50,Color.BLACK);
                rect3 = new rect(50, 100, 350,50,Color.BLACK);
                rect4 = new rect(450, 0, 50, 500,Color.BLACK);
                rect5 = new rect(100, 200, 350, 50,Color.BLACK);
                rect6 = new rect(50, 300, 350, 50,Color.BLACK);
                rect7 = new rect(350, 350, 50,50,Color.BLACK);
                rect8 = new rect(250, 400, 50, 50,Color.BLACK);
                rect9 = new rect(150, 350, 50, 50,Color.BLACK);
                rectS = new rect(50, 50, 50, 50,Color.BLUE);  // s
                rectE = new rect(50, 400, 50, 50,Color.RED);// e
                rectV1 = new rect(0, 500 , 500, 25,Color.ORANGE);
                
                
        }
 
        // painting squares on view frame
        public void paint(Graphics g) {
             	super.paint(g);
                Graphics2D g2d = (Graphics2D) g;
              
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect0.x, rect0.y, rect0.w, rect0.h); // x, y, width, height
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect1.x, rect1.y, rect1.w, rect1.h);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect2.x, rect2.y, rect2.w, rect2.h);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect3.x, rect3.y, rect3.w, rect3.h);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect4.x, rect4.y, rect4.w, rect4.h);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect5.x, rect5.y, rect5.w, rect5.h);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect6.x, rect6.y, rect6.w, rect6.h);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect7.x, rect7.y, rect7.w, rect7.h);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect8.x, rect8.y, rect8.w, rect8.h);
                g2d.setColor(Color.BLACK);
                g2d.fillRect(rect9.x, rect9.y, rect9.w, rect9.h);
                g2d.setColor(Color.BLUE);
                g2d.fillRect(rectS.x, rectS.y, rectS.w, rectS.h);
                g2d.setColor(Color.RED);
                g2d.fillRect(rectE.x, rectE.y, rectE.w, rectE.h);
                g2d.setColor(Color.ORANGE);
                g2d.fillRect(rectV1.x, rectV1.y, rectV1.w, rectV1.h);
               
        }
        
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
