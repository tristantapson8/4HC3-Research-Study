import java.awt.Color;
public class rect {
	
	int x, y, w, h;
	private Color c;

	public rect(int startX, int startY, int width, int height, Color color) {
		// TODO Auto-generated constructor stub
		x = startX;
		y = startY;
		w = width;
		h = height;
		c = color;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getW(){
		return w;
	}
	
	public int getH(){
		return h;
	}
	
	public Color getC(){
		return c;
	}
	
	public void setColor(Color c){
		this.c = c;
	}
}
