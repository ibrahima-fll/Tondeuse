import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args){
		String file = new String();
		boolean parite = false;
		//le programme est lancé sans parametre
		if (args.length == 0){
			System.out.println("Usage: ./prog filename");	
		}
		// le programme est lancé avec un parametre
		//on peut donc effectuer le traitement du fichier
		else if (args.length == 1){
			Tondeuse checkDestination = null;
			int x;
			int y;
			int i = 0;
			ArrayList<Tondeuse> tonds = new ArrayList<Tondeuse>();
			Pelouse pel= new Pelouse();
			String hd = new String();
			file = args[0];
			//lecture du fichier texte	
			try{
				// on ouvre le fichier et on initialise le buffer
				InputStream ips=new FileInputStream(file); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				
				// on lit la premiere ligne du fichier et on récupère les dimensions de la pelouse.
				String ligne;
				ligne = br.readLine();
				String [] spt = ligne.split(" ");
				pel.setWidth(Integer.parseInt(spt[0]));
				pel.setHeight(Integer.parseInt(spt[1]));
				// on parcourt le fichier
				while ((ligne = br.readLine()) != null){
					//on initialise une tondeuse
					if(!parite){// si parite est paire ( on lit les valeurs initiales d'une tondeuse )
						System.out.println("************************ Affichage tondeuse "
								+ (i+1) +" *************************");
						//on renouvelle la manoeuvre pour initialiser la tondeuse
						spt = ligne.split(" ");
						x = Integer.parseInt(spt[0]);
						y = Integer.parseInt(spt[1]);
						hd = spt[2];
						tonds.add(new Tondeuse(x,y,hd));
						parite = true;
					}
					//on deplace la tondeuse
					else{ // sinon on lit le deplacement de la tondeuse
						spt = ligne.split("");
						parite = false;
						for(String str : spt){
							System.out.println(str);
							if (str.equals("G") || str.equals("D")){
								tonds.get(i).newDirection(str);
							}// on tourne soit a gauche soit a droite
							else if (str.equals("A") && pel.isMoveAllowed(tonds.get(i))){
									checkDestination = new Tondeuse(tonds.get(i).getAbs(),tonds.get(i).getOrd(),tonds.get(i).getHead());
									pel.nextMove(checkDestination);
									if (pel.isEmpty(checkDestination, tonds)){
										tonds.get(i).move();
									}
							} // on avance
							System.out.println(tonds.get(i).toString(i+1));
						}
						i++; // on incremente i pour changer de tondeuse
					}//fin déplacement tondeuse
				}
				br.close(); // on ferme la connexion au fichier
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
		}
		// le programme est lancé avec plus d'un parametre
		else{
			System.out.println("Bad usage. The program require only one parameter.");
		}
	}
}
