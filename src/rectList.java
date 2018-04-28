
public class rectList {
	public rect[] thelist = new rect[1000];
	public int i;
	
	public void add(rect r){
		if(i < thelist.length){
			thelist[i] =r;
			i++;
		}
	}

	public int size(){
		return i;
	}
	
	public rect getVal(){
		return thelist[i];
	}
}
