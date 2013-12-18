package namerandomizer;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class LowerOne {
	public String VERSION = "0.5B";
	static ArrayList<String> nomes = new ArrayList<String>();
	public String nomesAll= "";
	Random onArray = new Random();
	public LowerOne(){
		
	}
	
	
	public void AddOne(){
		String nome = "";
		while (nome != null){
		nome = JOptionPane.showInputDialog(null, "Type in a name: ", "RANDOMIZER By Kamalcranio", -1);
		if (nome != null){
		nomes.add(nome);
		}
		}
		revises();
	}
	
	public void revises(){
		NameOrganize();
		if (nomesAll.equals("")){
			JOptionPane.showMessageDialog(null, "You can't leave it without nothing.", "Error", 0);
			cleanArray();
			AddOne();
		}
		int confirm = JOptionPane.showConfirmDialog(null, "Confirm the names: \n" + nomesAll);
		if (confirm == 0){
			tellResult();
		}else if(confirm == 2){
			System.exit(0);
		}else if(confirm == 1){
			cleanArray();
			AddOne();
			}		
		}
	
	public void cleanArray(){
		nomesAll = "";
		if(nomes.isEmpty()){
			return;
		}else if(!nomes.isEmpty()){
			nomes.clear();
			cleanArray();
		}
	}
	
	public int randomize(){
		return onArray.nextInt(nomes.size());
	}
	
	public void tellResult(){
		JOptionPane.showMessageDialog(null, "The choosen one is: \n" + nomes.get(randomize()));
	}
	
	public void NameOrganize(){
		int nomesTotal = nomes.size();
		int toArray = 0;
		while(toArray < nomesTotal){
			nomesAll = nomesAll + " - " + nomes.get(toArray);
			if((toArray & 1) == 0){
				nomesAll = nomesAll + "\n";
			}
			toArray++;
		}
	}
	
	public void start(){
		JOptionPane.showMessageDialog(null, "Randomizer V " + VERSION + "\nBy Kamalcranio", "Randomizer V " + VERSION, -1);
		JOptionPane.showMessageDialog(null, "Type in The name of people you want to select randomly.\n When done, press cancel.", "Randomizer V " + VERSION, -1);
		AddOne();
	}
}
