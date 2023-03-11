package web.bean;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

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
