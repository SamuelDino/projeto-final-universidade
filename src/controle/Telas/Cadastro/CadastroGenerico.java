package controle.Telas.Cadastro;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.sun.javadoc.Type;

import modelo.Disciplina;
import modelo.Escolaridade;

public class  CadastroGenerico extends DefaultTableModel {

	private static final long serialVersionUID = 1L;
	

	@SuppressWarnings("serial")
	public static <T,A> ArrayList<T> telaCadastroGenerico(String title, ArrayList<T> registros, String [][] tableHeader, String[][] getMethods, Class<T>[] classConstructor, String classForName, ArrayList<JComboBox> boxes, Class<A>[] classConstructorBox, String[][] getMethodsBox, String[] setMethodsBox) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
	
		
		int i,sizeWidth=0;
		
		for (i=0;i<tableHeader.length;i++) {
			sizeWidth += Integer.parseInt(tableHeader[i][1]);
		}
		
		JTable tableComboBox =  new JTable( (TableModel) new DefaultTableModel(  
				 
			     new Object [][] { }, new String[] {"Teste","",""})
					{  
					 	boolean[] canEdit = new boolean[] {true,false,false};
			      
					 	@Override    
					 	public boolean isCellEditable(int rowIndex, int columnIndex) {    
					 		return canEdit[columnIndex];    
					 	}
			        }
		);
		
		
		List<JTable> scopeTableComboBox = new ArrayList<JTable>();
		scopeTableComboBox.add(tableComboBox);
		
		DefaultTableModel modelTableBox = new DefaultTableModel();
		modelTableBox = (DefaultTableModel) tableComboBox.getModel();
		List<DefaultTableModel> scopeTableBoxModel = new ArrayList<DefaultTableModel>();
		scopeTableBoxModel.add(modelTableBox);
		
		
		JFrame frameCadastro = new JFrame(title);  //Título da Janela de Cadastro
		
		JButton buttonVoltar = new JButton("Voltar"); 
		buttonVoltar.setPreferredSize(new Dimension(sizeWidth,50)); // Dimensão do botao de controle voltar
		
		// -------------------- inicializa array com status de edição de cada coluna (dados = true / JButons = false)
		boolean[] canEditHeader;
		canEditHeader = new boolean [tableHeader.length];		
		
		String[] headerTitles;
		headerTitles = new String[tableHeader.length];
		
		
		for (i=0;i<=tableHeader.length-1;i++) {  
			if ((tableHeader.length-1-i)>1) {
				canEditHeader[i] = true;
			}else {
				canEditHeader[i] = false;
			}
			headerTitles[i] = tableHeader[i][0];
			
        }
		
		JTable tableCadastro =  new JTable( (TableModel) new DefaultTableModel(  
	 
			     new Object [][] { }, headerTitles)
					{  
					 	boolean[] canEdit = canEditHeader;
			      
					 	@Override    
					 	public boolean isCellEditable(int rowIndex, int columnIndex) {    
					 		return canEdit[columnIndex];    
					 	}
					 	
					 	
			        }
		); 
		
 
		
		tableCadastro.setSelectionBackground(Color.LIGHT_GRAY);
		
		DefaultTableModel modelTable = new DefaultTableModel();
		modelTable = (DefaultTableModel) tableCadastro.getModel();
		
		List<DefaultTableModel> scopeModelTable = new ArrayList<DefaultTableModel>();
		scopeModelTable.add(modelTable);
		
		tableCadastro.setRowHeight(25);
		tableCadastro.getTableHeader().setPreferredSize(new Dimension(sizeWidth,30)); // dimensão do cabeçalho e consequentimente da coluna
		tableCadastro.getTableHeader().setFont(new java.awt.Font("Kerala", 1, 14));
		tableCadastro.getTableHeader().validate();
		tableCadastro.getTableHeader().repaint();		
		
        JScrollPane scrollPane = new JScrollPane(tableCadastro);
		scrollPane.setPreferredSize(new Dimension(800,500)); // dimensção do box de escroll
	      
        JTableHeader header =  tableCadastro.getTableHeader();
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();        
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        
     
		tableCadastro.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);

		
		JButton buttonIncluir = Procedimento.getButton(Procedimento.Incluir.toString());		
		tableCadastro.getColumnModel().getColumn(tableHeader.length-2).setCellRenderer(new SetColorCellTable(buttonIncluir));
		
		JButton buttonExcluir = Procedimento.getButton(Procedimento.Excluir.toString());
		tableCadastro.getColumnModel().getColumn(tableHeader.length-1).setCellRenderer(new SetColorCellTable(buttonExcluir));
		
		for (i=0;i<=tableHeader.length-1;i++) {  // seta o tamanho das colunas
			tableCadastro.getColumnModel().getColumn(i).setPreferredWidth(Integer.parseInt(tableHeader[i][1]));
		}
		
		tableCadastro.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        
		
		Class localDateClass = LocalDate.class;
		Class stringClass = String.class;
		Class intClass = int.class;
		Class doubleClass = Double.class;
		Class listClass = java.util.List.class;
		Class escolaridadeClass = Escolaridade.class;
		
		Object[] cols = new Object[tableHeader.length];	
		Map<String, List<A>> treeMapCadastro = new TreeMap<>(); 
		treeMapCadastro.put("", null);
		
	 
		for(T d: registros) {	// insere na tabela/grid os registros do vetor de dados
			for (i=0;i<=tableHeader.length-1;i++) {
				if (getMethods[i][1]=="int.class") {
					cols[i] = d.getClass().getMethod(getMethods[i][0]).invoke(d).toString();
				}
				if (getMethods[i][1]=="String.class") {
					cols[i] = d.getClass().getMethod(getMethods[i][0]).invoke(d);
					if ((i==0) && (boxes!=null) && (cols[i]!=null)) {
						treeMapCadastro.put((String) cols[i], (List<A>) d.getClass().getMethod(getMethodsBox[1][0]).invoke(d));
					}

				}
				if (getMethods[i][1]=="LocalDate.class") {
					LocalDate date = (LocalDate) d.getClass().getMethod(getMethods[i][0]).invoke(d);	
					DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					cols[i] = "";
					if (date!=null) {
						cols[i] = date.format(formatDate);
					}
					
				}
				if (getMethods[i][1]=="") {
					cols[i] = "";
				}
				
			}			
			modelTable.addRow(cols);
			
		}
				
		tableCadastro.setFillsViewportHeight(false); 
		tableCadastro.setCellSelectionEnabled(true);
		
		JTabbedPane tabbledPane = new JTabbedPane();
		JPanel panelBox = new JPanel();
      
		buttonIncluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] cols = new Object[tableHeader.length];
				int i;
				for (i=0;i<=tableHeader.length-1;i++) {
					if (getMethods[i][1]=="int.class") {
						cols[i] = "0";
					}
					else {
						cols[i] = "";
					}
				}
		
				scopeModelTable.get(0).addRow(cols);
				treeMapCadastro.put((String) cols[0], null);
				tableCadastro.changeSelection(tableCadastro.getRowCount()-1,0,false,false);
				tableCadastro.requestFocusInWindow();
				
				
				}			
		});
		
		buttonExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scopeModelTable.get(0).removeRow(tableCadastro.getSelectedRow());	
				if (tableCadastro.getRowCount()==0){	
					registros.clear();;
					try {
						T newData = null;
						newData = (T) newData.getClass().getConstructor().newInstance("",0);
						registros.add(newData);
						buttonIncluir.doClick();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					;
				} 
			}			
		});
		
		buttonExcluir.validate();
		
        tableCadastro.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {

        	if ((boxes!=null)) {
    			if (!(tableCadastro.getModel().getValueAt(0,0)==null)) {
    				if (tabbledPane.getTabCount()==1) {
    					tabbledPane.addTab(tableCadastro.getModel().getValueAt(tableCadastro.getSelectedRow(),0).toString(),panelBox);
    				}
    				else
    				{
    					tabbledPane.setTitleAt(1, tableCadastro.getModel().getValueAt(tableCadastro.getSelectedRow(),0).toString());
    				}	
				}
    		}
        	
        	if(e.getClickCount() == 1){
        		if (tableCadastro.getSelectedColumn()==tableHeader.length-2) { // incluir
        			buttonIncluir.doClick();
        		}
        		
        		if (tableCadastro.getSelectedColumn()==tableHeader.length-1) { // excluir
        			buttonExcluir.doClick();
        		}
        		
        		
        	}
        }});
		
             
        tableCadastro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if (e.getExtendedKeyCode()==10) { 
					//KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
				    InputMap im = tableCadastro.getInputMap();
	                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Action.NextCell");
					tableCadastro.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
                    .put(KeyStroke.getKeyStroke("ENTER"), "Action.NextCell");
				}
			
			}});
        
        
        
		tableCadastro.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				
				
			}});

        
		buttonVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registros.clear();
				try {					
					Object[] valuesParemetersConstructor = new Object[classConstructor.length];
					int i,j;
					for(i=0;i<=tableCadastro.getRowCount()-1;i++) {
						String keyMap = "";
						for (j=0;j<=tableCadastro.getColumnCount()-3;j++) {
							if (classConstructor[j]==localDateClass) {
								DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");								
								valuesParemetersConstructor[j] = LocalDate.parse((String) tableCadastro.getValueAt(i, j), formatDate);
							}
							if (classConstructor[j]==stringClass) {
								valuesParemetersConstructor[j] = tableCadastro.getValueAt(i, j).toString();
								if (j==0) {
									keyMap = tableCadastro.getValueAt(i, j).toString();
								}
							}
							if (classConstructor[j]==intClass) {
								valuesParemetersConstructor[j] = Integer.parseInt((String) tableCadastro.getValueAt(i, j));
							}
							if (classConstructor[j]==doubleClass) {
								valuesParemetersConstructor[j] = Double.parseDouble((String) tableCadastro.getValueAt(i, j));
							}
							
							if (classConstructor[j]==escolaridadeClass) {
								valuesParemetersConstructor[j] = null;
							}
						
						}
						
						if (boxes!=null) {
							valuesParemetersConstructor[j] = treeMapCadastro.get(keyMap);	
						}
						
						Class classCadastro = Class.forName(classForName);
						Constructor<T> constructor = classCadastro.getConstructor(classConstructor);	
						T newData;
						newData = (T) constructor.newInstance(valuesParemetersConstructor);
						registros.add(newData);	
						
					
													
					}
				}catch(Exception e1){
					
				}
					
				
				if (registros.isEmpty())
					try {
						Object[] valuesParemetersConstructor = new Object[classConstructor.length];
						
						int i;
						for (i=0;i<=classConstructor.length-1;i++) {
							if (getMethods[i][1]=="Double.class") {
								valuesParemetersConstructor[i] = 0.0;
							}
							if (getMethods[i][1]=="int.class") {
								valuesParemetersConstructor[i] = 0;
							}
							if (getMethods[i][1]=="String.class") {
								valuesParemetersConstructor[i] = "";

							}
							if (getMethods[i][1]=="LocalDate.class") {
								valuesParemetersConstructor[i] = null;			
							}
							if (getMethods[i][1]=="Escolaridade.class") {
								valuesParemetersConstructor[i] = null;			
							}
						}
						
						Class classCadastro = Class.forName(classForName);
						Constructor<T> constructor = classCadastro.getConstructor(classConstructor);							
						T newData;
						newData = (T) constructor.newInstance(valuesParemetersConstructor);
						registros.add(newData);
						treeMapCadastro.put("",null);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				
				
				frameCadastro.dispose();
						
			}
			
		});
		
		
		
		
		JPanel mainPanel = new JPanel();
		JPanel panelTable = new JPanel(new BorderLayout());
		panelTable.setPreferredSize(new Dimension(sizeWidth,500));
		mainPanel.add(panelTable);;
		panelTable.add(scrollPane);
		
		JPanel footPanel = new JPanel();
		footPanel.setPreferredSize(new Dimension(sizeWidth,50));
		footPanel.add(buttonVoltar);
		mainPanel.add(footPanel);
		
		
		tabbledPane.addTab(title,mainPanel);
		tabbledPane.addTab("",panelBox);
	    
		if (boxes!=null) {
			for (JComboBox comboBox: boxes) {	
				
				List<JComboBox> scopeComboBox = new ArrayList<JComboBox>();
				scopeComboBox.add(comboBox);
				
				comboBox.setPreferredSize(new Dimension(500,30));
				
				panelBox.setPreferredSize(new Dimension(sizeWidth,700));

				tableComboBox.setPreferredSize(new Dimension(700,600));
				tableComboBox.setRowHeight(25);
				tableComboBox.getTableHeader().setPreferredSize(new Dimension(700,30)); // dimensão do cabeçalho e consequentimente da coluna
				tableComboBox.getTableHeader().setFont(new java.awt.Font("Kerala", 1, 14));	
				tableComboBox.setSelectionBackground(Color.LIGHT_GRAY);
						
				tableComboBox.setFillsViewportHeight(false); 
				tableComboBox.setCellSelectionEnabled(true);
				
				JButton buttonIncluirBox = Procedimento.getButton(Procedimento.Incluir.toString());
				tableComboBox.getColumnModel().getColumn(1).setCellRenderer(new SetColorCellTable(buttonIncluirBox));
				
				
				JButton buttonExcluirBox = Procedimento.getButton(Procedimento.Excluir.toString());
				tableComboBox.getColumnModel().getColumn(2).setCellRenderer(new SetColorCellTable(buttonExcluirBox));
				
				buttonExcluirBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						scopeTableComboBox.get(0).requestFocusInWindow();
						if ((tableComboBox.getSelectedRow()<0) && (tableComboBox.getRowCount()>0)) { // exclusão automatica
							scopeTableBoxModel.get(0).removeRow(0);
						}
						else {
							scopeTableBoxModel.get(0).removeRow(tableComboBox.getSelectedRow()); // exclusaõ clicando no button excluir
						}
										
            			if (scopeTableComboBox.get(0).getRowCount()==0) {	
            				String keyMap = scopeModelTable.get(0).getValueAt(tableCadastro.getSelectedRow(), tableCadastro.getSelectedColumn()).toString();
							if (treeMapCadastro.get(keyMap)==null) { // se valor do map null insere linha em branco com os botoes de controle (incluir/excluir)
								scopeTableBoxModel.get(0).addRow(new Object[] {"","",""});
							}           					
            			}            			
            			
					}});
				
				JButton voltarBox = new JButton("Voltar");
				voltarBox.setPreferredSize(new Dimension(500,30));
				buttonExcluirBox.validate();
											
				tableComboBox.addMouseListener(new MouseAdapter() {
		            public void mouseClicked(MouseEvent e) {
		            	if(e.getClickCount() == 1){  // um click

		            		if (scopeTableComboBox.get(0).getSelectedColumn()==1) { // Incluir		
		            			if (comboBox.getItemCount()>0) {
		            				Object[] colums = new Object[] {comboBox.getSelectedItem().toString(),"",""};
		            				if (scopeTableBoxModel.get(0).getValueAt(0, 0)=="") {
		            					scopeTableBoxModel.get(0).removeRow(0);
		            				}
		            				scopeTableBoxModel.get(0).addRow(colums);
		            			}
		            			
		            		}
		            		
		            		if (scopeTableComboBox.get(0).getSelectedColumn()==2) { // Excluir		
		            			buttonExcluirBox.doClick();
		            		}		            				          
		            	}
		            }});
				
				tabbledPane.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {	
						tableCadastro.requestFocusInWindow();
						tableCadastro.editCellAt(tableCadastro.getSelectedRow(), tableCadastro.getSelectedColumn());
						
						String keyMap = tableCadastro.getValueAt(tableCadastro.getSelectedRow(), tableCadastro.getSelectedColumn()).toString();
						
						if ((tabbledPane.getTitleAt(tabbledPane.getSelectedIndex())==keyMap) && (keyMap!="")) { // se chave não vazia
							
							if (treeMapCadastro.get(keyMap)!=null) { // se valor não vazio
								
								// exlui todas as linhas da tableComboBox
								int i,numRows;
								numRows = scopeTableComboBox.get(0).getRowCount();
								for (i=0;i<numRows;i++) {
									scopeTableComboBox.get(0).requestFocusInWindow();
									buttonExcluirBox.doClick();
								}
								//------------------------------------------<
	
								Object[] col = new Object[1];
								for(A d: treeMapCadastro.get(keyMap)) {	// insere na tabela os registros do map
									try {
										col[0] = d.getClass().getMethod(getMethodsBox[0][0]).invoke(d).toString();			
										scopeTableBoxModel.get(0).addRow(col);
									}
									catch(NullPointerException ex ) {
										
									} catch (IllegalAccessException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (IllegalArgumentException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (InvocationTargetException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (NoSuchMethodException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SecurityException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

								}								
							}
							else { // keyMap==null - inclue linha em branco com os botoes de controle (incluir/excluir)
								scopeTableBoxModel.get(0).addRow(new Object[] {"","",""});
							}
						}
					}
					
				});
				

				
				voltarBox.addActionListener(new ActionListener() { // Voltar
					@Override
					public void actionPerformed(ActionEvent e) {
						List<A> arrayListComboItens = new ArrayList<A>();
						
						Object[] valuesParemetersConstructor = new Object[2];
						
						int i;
						
						for(i=0; i<scopeTableComboBox.get(0).getRowCount();i++) {
							 try {
								valuesParemetersConstructor[0] = scopeTableBoxModel.get(0).getValueAt(i, 0);
								valuesParemetersConstructor[1] = 0; // numero de horas
								Class classCadastro = Class.forName(scopeComboBox.get(0).getName());
								Constructor<A> constructor = classCadastro.getConstructor(classConstructorBox);							
								A newData;
								newData = (A) constructor.newInstance(valuesParemetersConstructor);
								arrayListComboItens.add(newData);	
								
							
							} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
									| InvocationTargetException | NoSuchMethodException | SecurityException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}						
						
						
						if (arrayListComboItens!=null) {
							String keyMap = scopeModelTable.get(0).getValueAt(tableCadastro.getSelectedRow(), tableCadastro.getSelectedColumn()).toString();
							treeMapCadastro.put(keyMap, arrayListComboItens);
						}
						
						int f,numRows;
						
						numRows = scopeTableComboBox.get(0).getRowCount();
						
						for (f=0;f<numRows;f++) {
							scopeTableComboBox.get(0).requestFocusInWindow();
							buttonExcluirBox.doClick();
						}

						tabbledPane.setSelectedIndex(0);  // Volta para a aba (Table/Grid) Cadastro principal
					}			
				});
								
				tableComboBox.getColumnModel().getColumn(0).setPreferredWidth(600);
				tableComboBox.getColumnModel().getColumn(1).setPreferredWidth(80);
				tableComboBox.getColumnModel().getColumn(2).setPreferredWidth(80);
				
				tableComboBox.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
				tableComboBox.getTableHeader().validate();
				tableComboBox.getTableHeader().repaint();
			
		        JScrollPane scrollTablePaneBox = new JScrollPane(tableComboBox);
		        scrollTablePaneBox.setPreferredSize(new Dimension(800,700));
		        
		        JPanel scrollBox = new JPanel();		        
		        scrollBox.setPreferredSize(new Dimension(800,600));
		        scrollBox.add(scrollTablePaneBox);
		        panelBox.add(scrollBox);
		        
		        JPanel comboBoxBox = new JPanel();
		        comboBoxBox.setPreferredSize(new Dimension(500,600));
		        
		        comboBoxBox.add(comboBox);
		        comboBoxBox.add(voltarBox);
		        panelBox.add(comboBoxBox);				
			}
		}

		frameCadastro.add(tabbledPane);  
		frameCadastro.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frameCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCadastro.pack();
		frameCadastro.setVisible(true);
			
		return registros;
	}
	
}




