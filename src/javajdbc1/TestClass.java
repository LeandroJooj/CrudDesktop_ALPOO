package javajdbc1;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author george
 */
public class TestClass {
    
    public PegaDado Pegador;
    public static JTable tabela1 = new JTable(new ModeloTitulo(PegaDado.genElemTableTabel1()));
    public static JTable tabela2 = new JTable(new ModeloDaTabela(PegaDado.genElemTable()));
    
    public static JPanel CriaPainel(){
        JPanel Painel = new JPanel();         
        JPanel Painel4 = new JPanel(); 
        Painel4.setLayout(new GridLayout());
        
        JPanel Painel5 = new JPanel(); 
        Painel5.setLayout(new GridLayout());
        
        JMenuBar menu = new JMenuBar();
        JMenu Cadastrar = new JMenu("Cadastrar"); 
        JMenu Mostrar = new JMenu("Mostrar"); 
        JMenu Sair = new JMenu("Sair");
        
        MenuListener Cads = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
                TelaCadastro.telaSelecao();
            }

            @Override
            public void menuDeselected(MenuEvent me) {
                
            }

            @Override
            public void menuCanceled(MenuEvent me) { 
                
            }
            
        };
        MenuListener Most = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
                TelaCadastro.telaMostrar();
            }

            @Override
            public void menuDeselected(MenuEvent me) {
              
            }

            @Override
            public void menuCanceled(MenuEvent me) {
               
            }
        };
        MenuListener SairMenu = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
                System.exit(0);
            }

            @Override
            public void menuDeselected(MenuEvent me) {
                
            }

            @Override
            public void menuCanceled(MenuEvent me) { 
                
            }
            
        };
        
        Cadastrar.addMenuListener(Cads);
        Mostrar.addMenuListener(Most);
        Sair.addMenuListener(SairMenu);
        
        menu.add(Cadastrar);        
        menu.add(Mostrar);
        menu.add(Sair);


        Sair.addActionListener((java.awt.event.ActionEvent eventa) -> {
            System.exit(0);
        });
      
        
        
       Painel.add(menu);
       Painel5.add(tabela1);
        Painel4.add(tabela2);
        Painel.add(Painel5);
        Painel.add(Painel4);
        
        
        return Painel;
    }		
}
