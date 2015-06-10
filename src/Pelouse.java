import java.util.ArrayList;

public class Pelouse {
	private int width;
	private int height;
	
	public boolean isEmpty(int x, int y, String hd){
		return false;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean isMoveAllowed(Tondeuse t){
		if (t.getHead().equals("E") && t.getAbs() == getWidth() ){
			System.out.println("Déplacement vers l'Est non autorisé");
			return false;
		}
		else if (t.getHead().equals("N") && t.getOrd() == getHeight() ){
			System.out.println("Déplacement vers le Nord non autorisé");
			return false;
		}
		else if (t.getHead().equals("S") && t.getOrd() == 0){
			System.out.println("Déplacement vers le Sud non autorisé");
			return false;
		}
		else if (t.getHead().equals("W") && t.getAbs() == 0){
			System.out.println("Déplacement vers l'Ouest non autorisé");
			return false;
		}
		return true;
	}
	
	public void nextMove(Tondeuse t){
		if(t.getHead().equals("N")){
			t.setOrd(t.getOrd() + 1);
		}
		else if(t.getHead().equals("S")){
			t.setOrd(t.getOrd() - 1);
		}
		else if(t.getHead().equals("E")){
			t.setAbs(t.getAbs() + 1);
		}
		else if(t.getHead().equals("W")){
			t.setAbs(t.getAbs() - 1);
		}
		else
			System.out.println("Cette direction n'est pas acceptée");
	}
	
	public boolean isEmpty(Tondeuse check, ArrayList<Tondeuse> tonds){
		for( Tondeuse tond:tonds){
			if (check.getAbs() == tond.getAbs() && check.getOrd() == tond.getOrd()){
				System.out.println("Emplacement déja occupé par une tondeuse");
				return false;
			}
		}
		return true;
	}
}
