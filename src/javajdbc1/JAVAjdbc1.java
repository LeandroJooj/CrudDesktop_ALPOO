package javajdbc1;
import DAO.Connect;
import javax.swing.JFrame;
/**
 *
 * @author george
 */
public class JAVAjdbc1 {
    
  
    

    public static void main(String[] args){
        JFrame tela = new JFrame();
        Connect.GetConnection();
        System.out.println("conexão bem sucedida");
        tela.setTitle("Menu Principal");
        tela.setResizable(false);
        tela.add(TestClass.CriaPainel());
        tela.setSize(500,500);
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TelaCadastro.tela();
        

    }


}