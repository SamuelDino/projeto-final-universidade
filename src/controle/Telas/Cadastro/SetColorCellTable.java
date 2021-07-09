package controle.Telas.Cadastro;



import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


@SuppressWarnings("serial")
public class SetColorCellTable<T> extends DefaultTableCellRenderer implements TableCellRenderer {

	private Component button;

		
	public SetColorCellTable(Component button) {
		super();
		this.button = button;
	}


	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
        
     
        return this.button;      
    }   

	
}
