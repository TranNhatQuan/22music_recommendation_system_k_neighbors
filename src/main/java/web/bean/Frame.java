package web.bean;

import java.io.FileWriter;

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
