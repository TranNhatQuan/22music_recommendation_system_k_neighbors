/* Online Java Compiler and Editor */
public class HelloWorld{
    public class Rectangle {
	private int len;
	private int wid;
	public Rectangle() {
		
		this.len = 0;
		this.wid = 0;
	}
	public Rectangle(int l, int w) {
	
		this.len = l;
		this.wid = w;
	}
	
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public void display() {
		System.out.println(this.len);
		System.out.println(this.wid);
	}
	
}
    public class Frame {
	private Rectangle rec;
	private String title;
	public Frame() {
		
		this.rec = new Rectangle();
		this.title = "";
	}
	public Frame(int l, int w, String title) {
		
		this.rec = new Rectangle(l, w);
		this.title = title;
	}
	public void display() {
		System.out.println(this.title);
		System.out.println(this.rec.getLen());
		System.out.println(this.rec.getWid());
	}
	public void save() {
		
		 try {
	            FileWriter fw = new FileWriter("rectangle_info.txt");
	            fw.write(""+this.title+" "+this.rec.getLen()+" "+this.rec.getWid());
	            fw.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        System.out.println("Success...");
		
	}
}
     public static void main(String []args){
        Frame fr = new Frame(200,200,"Sample Frame");
        fr.display();
        fr.save();
        
     }
}