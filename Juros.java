import java.awt.event.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Juros extends JPanel{  
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JLabel lbpreco, lbparcela, lbBRD, inv1, inv2, inv3, lbre1, lbre2, lbre3;
		JTextField tfpreco; 
		MaskFormatter msIP, mspreco; 
		JButton btCALC, btCANCELAR, btLIMPAR;
		 JComboBox<?> lparcela; 
		JScrollPane sppre;

		
		double conta, mes, mespar; 
		String jurosfinal;

		
		
		public Juros(){
			InicializarComponentes();
			DefinirEventos();
}
		
		public void InicializarComponentes(){
			try{
			setLayout(null);
			
		String[] parcela = {"A vista - 5% de desconto","12 vezes - 3% de juros","24 vezes - 5% de juros","36 vezes - 10% de juros","48 vezes - 15% de juros"};
			lparcela = new JComboBox(parcela);
			sppre = new JScrollPane(lparcela);// adiciona a lista ao scroll
			sppre.setBounds(5, 105, 200, 40);
			 
			 mspreco = new MaskFormatter("######,00");
			//ARRUMAR ESSA PARTE
			 tfpreco= new JFormattedTextField();
			 tfpreco.setBounds(5, 30, 80, 30);
			 add(tfpreco);
			 		 	
			 lbpreco = new JLabel("Digite o valor do carro");
			 lbpreco.setBounds(5, 10, 300, 20);
			 add(lbpreco);
			
			 lbparcela = new JLabel("Escolha em quantas parcelas você vai querer");
			 lbparcela.setBounds(5, 85, 300, 20);
			 add(lbparcela);

			 inv1 = new JLabel("");
			 inv2 = new JLabel("");
			 inv3 = new JLabel("");
			 lbre1 = new JLabel("O número de hosts disponiveis é:");
			 lbre2 = new JLabel("O número do prefixo é:");
			 lbre3 = new JLabel("A primeira subrede vai ser:");
			 inv1.setBounds(400, 420, 120, 50);
			 inv2.setBounds(400, 400, 120, 50);			 
			 inv3.setBounds(400, 160, 120, 50);
			 
			 
			
			 
			 btCALC = new JButton("Calcular");
			 btCANCELAR = new JButton("Sair");
			 btLIMPAR = new JButton("Limpar");
			 
			 btCALC.setBounds(0, 200, 100, 40);
			 btCANCELAR.setBounds(120, 200, 100, 40);
			 btLIMPAR.setBounds(60,250,100,40);
			 
			
			 add(btCALC);
			 add(btCANCELAR);
			 add(btLIMPAR);
			 
			 add(sppre);
		}
			catch(ParseException erro){
			erro.printStackTrace();
		} 
		}
		public void DefinirEventos(){
			
			btCALC.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){	
					
					double juros;
					
					conta =Integer.parseInt(tfpreco.getText());
					   
					if(lparcela.getSelectedIndex()==0){
					juros = conta - (conta*0.05) * 1;
				    jurosfinal= String.valueOf(juros); 
			       
			      
													  }
					
					if(lparcela.getSelectedIndex()==1){
						mespar = conta * 0.03;
					    juros = conta + mespar;
					    jurosfinal= String.valueOf(juros);
					    mes = juros / 12; //ver como arredondar
					}
					
					
					if(lparcela.getSelectedIndex()==2){
						mespar = conta * 0.05;
					    juros = conta + mespar;
					    jurosfinal= String.valueOf(juros);
					    mes = juros / 24; //ver como arredondar
					}
					
					
					if(lparcela.getSelectedIndex()==3){
						mespar = conta * 0.1;
					    juros = conta + mespar;
					    jurosfinal= String.valueOf(juros);
					    mes = juros / 36; //ver como arredondar
					}
					
					if(lparcela.getSelectedIndex()==4){
					    mespar = conta * 0.15;
					    juros = conta + mespar;
					    jurosfinal= String.valueOf(juros);
					    mes = juros / 48; //ver como arredondar
					}
					
					
					JOptionPane.showMessageDialog(null,"O valor original é: " +conta+ "0 reais" +
					"\nO valor total a pagar vai ser: " +jurosfinal+ "0 reais"+
					"\nO valor de cada parcela que terá que ser paga ao mês é de: "+mes+ "0 reais"+
					"\nE por causa dos juros, você ira pagar: " + mespar + "0 reais a mais do valor original");
					
					//VER SE TEM COMO ARRRUMAR OS PONTOS 
					//CONFERIR SE OS JUROS ESTÃO CERTOS
				
				}});
			
			btLIMPAR.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){	
				tfpreco.setText(" ");
				
			    
								}	
						});
			
			btCANCELAR.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){	
					System.exit(0);
}	
	});

}		
		public static void main (String args[]){
			 JFrame frame = new JFrame("Calculando Juros");
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 frame.getContentPane().add(new Juros()); 
			 frame.setBounds(200, 200, 450, 400);
			 frame.setVisible(true);

}
		
}