package javajdbc1;
import DAO.DadosException;
import DAO.getters;
import Gerenciador.GerenciadorDeElementos;
import JFrames.CadsAluno;
import JFrames.CadsProf;
import JFrames.CadsDisci;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
import javax.swing.JButton; 
import javax.swing.JComboBox;
//import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
/**
 *
 * @author george
 */
public class TelaCadastro {
       static NomeDoCurso[]         NomCurso = NomeDoCurso.values();
       static JComboBox             NomeCurso = new JComboBox(NomCurso);;         
       static ListElementosTable    Cast = new ListElementosTable();         
       static   getters             executor =              new getters();
       JPanel                       painel =                        new JPanel();
       static   JTextField          CodigoCurso =        new JTextField("0",20);       
       static   ButtonGroup         TipoCurso1 = new ButtonGroup();
       static ButtonModel           selecao =  TipoCurso1.getSelection();
       
       static   JTextField          CargaHoraria =       new JTextField("0", 20);
       static   JTextField          CodigoInstituicao =  new JTextField("0", 20);
       
       

       
      
       //tela mostrar
        static JButton Curso = new JButton("Curso");
        
        static JButton Disciplina = new JButton("Disciplina");
        static JButton Aluno = new JButton("Aluno");
        static JButton Professor = new JButton("Professor");
        static JButton Cursos_e_professores = new JButton("Cursos e professores");
        static JButton Curso_e_disciplinas = new JButton("Cursos e disciplinas");
        static JButton Professores_e_Disciplinas = new JButton("Professores e disciplinas");
        static JButton Aluno_e_disciplina = new JButton("Aluno e disciplina");
       
        
        // tela cadatro
        static JButton BotaoSalvar = new JButton("Clique aqui para salvar");
        
        // radiobuttons
        static JRadioButton Bacharel = new JRadioButton("Bacharel"); 
        static JRadioButton Gestao = new JRadioButton("Gestão"); 
        static JRadioButton Outros = new JRadioButton("Outros"); 
    public static JFrame tela(){
        
        JFrame ConteudoTela = new JFrame(); 
        
        JPanel MainPainel = new JPanel();
        TelaCadastro acesso = new TelaCadastro();      
        //executor.incluir(CodCu2);

        ConteudoTela.setVisible(true);
        ConteudoTela.setSize(550,500);
        ConteudoTela.setResizable(false);
        ConteudoTela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        BotaoSalvar.addActionListener((java.awt.event.ActionEvent iventa) -> {
           salvarElem();
           
           ConteudoTela.dispose();
        });
        ConteudoTela.setTitle("Tela de Cadastro de curso");
        
        MainPainel.add(acesso.Painel());
        MainPainel.add(BotaoSalvar);
        ConteudoTela.add(MainPainel);
        
        return ConteudoTela; 
    }
    
    public JPanel Painel(){
        JLabel labelCodCurso = new JLabel("digite o código do curso");
        JLabel labelNomeCurso = new JLabel("digite o nome do curso");
        JLabel LabelTipoCurso = new JLabel("digite o tipo do curso");
        JLabel LabelCargaHoraria = new JLabel("digite a carga horária");
        JLabel LabelCodigInst = new JLabel("digite o código da instituição");
        

        JPanel painel2 = new JPanel(); 
        
        
        TipoCurso1 = new ButtonGroup();
        TipoCurso1.add(Bacharel);
        TipoCurso1.add(Gestao);
        TipoCurso1.add(Outros);
        
        Bacharel.setActionCommand("BACHAREL");
        Gestao.setActionCommand("GESTAO");
        Outros.setActionCommand("OUTROS");
        
        Bacharel.setSelected(true);
        
        painel2.add(Bacharel);
        painel2.add(Gestao);
        painel2.add(Outros);
               
        painel.add(labelCodCurso);
        painel.add(CodigoCurso);
        painel.add(labelNomeCurso);
        painel.add(NomeCurso);
        painel.add(LabelTipoCurso);
        painel.add(painel2);
        painel.add(LabelCargaHoraria);
        painel.add(CargaHoraria);
        painel.add(LabelCodigInst);
        painel.add(CodigoInstituicao);
        
        painel.setLayout(new GridLayout(9, 1));
        
        return painel;
    }
    
    public static JFrame telaSelecao(){
        
        JFrame ConteudoTela = new JFrame(); 
        JButton CadsCurso = new JButton("Curso");
        JButton Disciplina = new JButton("Disciplina");
        JButton Aluno = new JButton("Aluno");
        JButton Professor = new JButton("Professor");
        
        JPanel MainPainel = new JPanel();
        ConteudoTela.setVisible(true);
        ConteudoTela.setSize(500,200);
        ConteudoTela.setResizable(false);
        ConteudoTela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        CadsCurso.addActionListener((java.awt.event.ActionEvent iventa) -> {
           tela();
           ConteudoTela.dispose();
        });
        
        Aluno.addActionListener((java.awt.event.ActionEvent iventa) -> {
           CadsAluno alun = new CadsAluno();
           alun.setVisible(true);
           alun.setTitle("tela de cadstro de aluno");
           alun.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
           ConteudoTela.dispose();
        });
        ConteudoTela.setTitle("Tela de seleção de cadastro");
        
        Professor.addActionListener((java.awt.event.ActionEvent iventa) -> {
           CadsProf prof = new CadsProf();
           prof.setVisible(true);
           prof.setTitle("tela de cadastro de professor");
           prof.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
           ConteudoTela.dispose();
        });
        
        Disciplina.addActionListener((java.awt.event.ActionEvent iventa) -> {
            CadsDisci disc = new CadsDisci(); 
            disc.setVisible(true);
            disc.setTitle("Tela de cadastro de disciplina");
            disc.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            ConteudoTela.dispose();
        });
        
        MainPainel.add(CadsCurso);
        MainPainel.add(Disciplina);
        MainPainel.add(Aluno);
        MainPainel.add(Professor);
        ConteudoTela.add(MainPainel);
        
        return ConteudoTela; 
    }
   
    public static JFrame telaMostrar(){
        
        JFrame ConteudoTela = new JFrame(); 
        
        Curso.addActionListener((java.awt.event.ActionEvent iventa) -> {
           atualizaTabela();
           ConteudoTela.dispose();
           
        });
                
        JPanel MainPainel = new JPanel();
       MainPainel.setLayout(new GridLayout(8, 1));
        ConteudoTela.setVisible(true);
        ConteudoTela.setSize(500,500);
        ConteudoTela.setResizable(false);
        ConteudoTela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
      //  BotaoSalvar.addActionListener((java.awt.event.ActionEvent iventa) -> {
      //     ConteudoTela.dispose();
       // });
        ConteudoTela.setTitle("Selecione o conteúdo a ser mostrado");
        
        MainPainel.add(Curso);
        MainPainel.add(Disciplina);
        MainPainel.add(Aluno);
        MainPainel.add(Professor);
        MainPainel.add(Cursos_e_professores);
        MainPainel.add(Curso_e_disciplinas);
        MainPainel.add(Professores_e_Disciplinas);
        MainPainel.add(Aluno_e_disciplina);
        ConteudoTela.add(MainPainel);
        
        return ConteudoTela; 
    }
    
        private static ListElementosTable getElemAlterado() {
        ListElementosTable ElementoAlterado = new ListElementosTable();
        ElementoAlterado.setCodCurso(Integer.parseInt(CodigoCurso.getText()));
        NomeDoCurso nameCourse = (NomeDoCurso) NomeCurso.getSelectedItem();
        //NomeDoCurso nameCourse = (NomeDoCurso) NomeCurso.getSelectedItem();
        ElementoAlterado.setNomeDoCurso(nameCourse);
        TipoCurso tipo = selec();
        ElementoAlterado.setTipoDeCurso(tipo);
        ElementoAlterado.setCargaHoraria(Integer.parseInt(CargaHoraria.getText()));
        ElementoAlterado.setCodigoInstituicao(Integer.parseInt(CodigoInstituicao.getText()));
        return ElementoAlterado;
    }
        
       static TipoCurso selec(){
           TipoCurso result = null;
           boolean radio1 = Bacharel.isSelected();
           boolean radio2 = Gestao.isSelected();
           boolean radio3 = Outros.isSelected();
           if(radio1 == true){
               result = TipoCurso.BACHAREL;
           }
           else if(radio2 == true){
               result = TipoCurso.GESTAO;
           }
           
           else if(radio3 ==true){
               result = TipoCurso.OUTROS;
           }
           else{
               result = TipoCurso.BACHAREL;
           }
           
           return result;
        }

   static void atualizaTabela() {
        new Thread() {
            @Override
            public void run() {
                Object itemSelecionado = selec();
                TipoCurso tipoSelecionado = null;
                if (itemSelecionado instanceof TipoCurso) {
                    tipoSelecionado = (TipoCurso) itemSelecionado;
                }
                try {
                    List<ListElementosTable> listaFiltrada = GerenciadorDeElementos.getPorTipo(tipoSelecionado);
                    ModeloDaTabela model = (ModeloDaTabela) TestClass.tabela2.getModel();
                    model.setLista(listaFiltrada);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            TestClass.tabela2.repaint();
                            TestClass.tabela2.revalidate();
                        }
                    });
                } catch (DadosException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível realizar a busca",
                            "Busca", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }.start();
    }
//    
static ListElementosTable ElemAlterado = getElemAlterado();

        public static void salvarElem() {
            
            try {
                GerenciadorDeElementos.salvar(ElemAlterado);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível confirmar a operação",
                        "Confirmação", JOptionPane.ERROR_MESSAGE);
            }
            Cast = ElemAlterado;
            atualizaTabela();
            SwingUtilities.invokeLater(new Runnable() {
                
                @Override
                public void run() {
                   BotaoSalvar.setEnabled(true);
                    CodigoCurso.setText(Cast.getCodCurso().toString());
                }
            });
        }

}








