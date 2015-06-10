
public class Tondeuse {
	private int abs;
	private int ord;
	private String head;
	private String direction;
	
	public Tondeuse(int x, int y, String pos){
		this.abs = x;
		this.ord = y;
		this.head = pos;
	}
	
	public void move(){
		if(this.getHead().equals("N")){
			setOrd(getOrd() + 1);
		}
		else if(this.getHead().equals("S")){
			setOrd(getOrd() - 1);
		}
		else if(this.getHead().equals("E")){
			setAbs(getAbs() + 1);
		}
		else if(this.getHead().equals("W")){
			setAbs(getAbs() - 1);
		}
		else
			System.out.println("Cette direction n'est pas acceptée");
	}
	
	public void newDirection(String a){
		if(this.getHead().equals("N")){
			if(a.equals("G")){
				setHead("W");
			}
			else if(a.equals("D")){
				setHead("E");
			}
		}
		else if(this.getHead().equals("S")){
			if(a.equals("G")){
				setHead("E");
			}
			else if(a.equals("D")){
				setHead("W");
			}
		}
		else if(this.getHead().equals("E")){
			if(a.equals("G")){
				setHead("N");
			}
			else if(a.equals("D")){
				setHead("S");
			}
		}
		else if(this.getHead().equals("W")){
			if(a.equals("G")){
				setHead("S");
			}
			else if(a.equals("D")){
				setHead("N");
			}
		}
	}
	
	public String toString(int i) {
		return "Tondeuse "+i+" : [abs=" + abs + ", ord=" + ord + ", head=" + head + "]";
	}

	public int getAbs() {
		return abs;
	}
	
	public void setAbs(int abs) {
		this.abs = abs;
	}
	
	public int getOrd() {
		return ord;
	}
	
	public void setOrd(int ord) {
		this.ord = ord;
	}
	
	public String getHead() {
		return head;
	}
	
	public void setHead(String head) {
		this.head = head;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
