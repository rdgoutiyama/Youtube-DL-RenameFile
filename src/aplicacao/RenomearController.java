package aplicacao;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class RenomearController {
	private String path;
	
	public RenomearController(String path){
		if (path.equals(""))
			throw new NullPointerException("Diretório vazio!");
			
		this.path = path;
		renomear();
	}
	
	public void renomear(){
		File directory = new File(path);
		File[] files = directory.listFiles();
		
		for(File file : files){
			renameExecute(file);
		}
		
		JOptionPane.showMessageDialog(null, "Arquivos Renomeados com Sucesso!!!");
	}
	
	private void renameExecute(File file){
		try {
			String filePath = file.getParent();
			String fileName = file.getAbsoluteFile().getName();
			String fileType = file.getAbsoluteFile().getName().substring(fileName.indexOf("."), fileName.length());

			int endindex = fileName.length() - (fileType.length() + 12);
			String nomeArquivoFinal = fileName.substring(0, endindex) + fileType;

			File newFile = new File(filePath + "/" + nomeArquivoFinal);
			newFile.setExecutable(true);
			newFile.setReadable(true);
			newFile.setWritable(true);

			//Para unix:
			Runtime.getRuntime().exec("chmod 777 " + newFile.getAbsoluteFile().getAbsolutePath());
			file.renameTo(newFile);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}
}
