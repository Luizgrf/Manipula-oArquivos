package aula;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import javax.swing.JOptionPane;

public class Arquivo {
		 static String dados[] = new String[10];
		 
		 public static void gravar() throws IOException {

		 FileWriter arq = new FileWriter("d:\\teste.txt");
		 PrintWriter gravarArq = new PrintWriter(arq);
		 for(int i = 0; i < 10; i++) {
			 gravarArq.println("valor de i: " + i); 
		 }		
		 arq.close();
		 }
		 
		 public static void excluir() throws IOException {	 
			 FileReader arqleitura = new FileReader("d:\\teste.txt");
			 BufferedReader lerArq = new BufferedReader(arqleitura);
			 
		     int num_linha = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número da linha para exclusão: "));
		    
		     String lerlinha = lerArq.readLine(); 
		     int i = 0;
		     while (lerlinha != null) {
		    	 if((i+1) != num_linha && lerlinha.contains("valor de i")) {
		    		 dados[i] = lerlinha;
		    	 }
		    	 i++; 
		    	 lerlinha = lerArq.readLine();
		     }
		     
		     FileWriter arq = new FileWriter("d:\\teste.txt");
			 PrintWriter gravarArq = new PrintWriter(arq);
			 for(int j = 0; j < 10; j++) {
				 gravarArq.println(dados[j]); 
			 }		
			 arq.close();
			 }
		
		 public static void atualizar() throws IOException {
			 FileReader arqleitura = new FileReader("d:\\teste.txt");
			 BufferedReader lerArq = new BufferedReader(arqleitura);
			 
		     int num_linha = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número da linha para alteração: "));
		     int novo_num = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o novo valor de i: "));
	
		     String lerlinha = lerArq.readLine(); 
		     int i = 0;
		     while (lerlinha != null) {
		    	 if((i+1) == num_linha) {
		    	 	 dados[i] = "valor de i: "+ novo_num;
		    	 }
		    	 else if(lerlinha.contains("valor de i")) 
		    		 dados[i] = lerlinha;
		    	 
		    	 i++; 
		    	 lerlinha = lerArq.readLine();
		     }
		     
		     FileWriter arq = new FileWriter("d:\\teste.txt");
			 PrintWriter gravarArq = new PrintWriter(arq);
			 for(int j = 0; j < 10; j++) {
				 gravarArq.println(dados[j]); 
			 }		
			 arq.close();
		 }
		
		 public static void leitura () throws IOException	{ 
			 FileReader arqleitura = new FileReader("d:\\teste.txt");
		 	 BufferedReader lerArq = new BufferedReader(arqleitura);
		     String lerlinha = lerArq.readLine(); 
		      
		     int i = 0;
		     while (lerlinha != null) {
		    	 i++;
		    	 if(lerlinha.contains("valor de i")) {
		    		 System.out.println("linha: " + i + " conteúdo: " + lerlinha); 
		    	 } 
		    	 lerlinha = lerArq.readLine();
		     }
		     
		     arqleitura.close();
		 }
	
			public static void main(String args[]) throws Exception {
				gravar();
				atualizar();
				excluir();
				leitura();
				
				
			}
}
