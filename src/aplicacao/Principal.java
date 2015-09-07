package aplicacao;

import javax.swing.JFileChooser;

public class Principal {
	
	public Principal(){
		new RenomearController(selectDirectory());
	}
	
	public static void main(String args[]){
		new Principal();
	}
	
	private String selectDirectory(){
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		if (chooser.showDialog(null, "Selecionar") == JFileChooser.APPROVE_OPTION)
			return chooser.getSelectedFile().getAbsolutePath();
		
		return "";
	}
}
