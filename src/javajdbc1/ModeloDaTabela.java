package javajdbc1;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
/**
 *
 * @author george
 */
public class ModeloDaTabela implements TableModel {
    private List<ListElementosTable> lista;
    
    public ModeloDaTabela(List<ListElementosTable> lista){
        this.lista = lista;
    }
    
        @Override
        public int getRowCount() {
            return lista.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public String getColumnName(int i) {
            
            switch(i){
                case 0: return "Código do Curso";
                                
                case 1: return "Nome do curso";
                                
                case 2: return "Tipo do curso";
                                
                case 3: return "Carga horária";
                                
                case 4: return "Código da instituição";
             }
            return "";
        }

        @Override
        public Class<?> getColumnClass(int i) {            
            switch(i){
                case 0:return int.class; 
                    
                case 1: return NomeDoCurso.class; 
                
                case 2: return TipoCurso.class; 
                
                case 3: return int.class;
                
                case 4: return int.class;
            }
            return Object.class;
        }

        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }

        @Override
        public Object getValueAt(int linha, int coluna) {
               ListElementosTable ObjetoAtual = lista.get(linha);
               switch(coluna){
                   case 0: return ObjetoAtual.getCodCurso();
                   case 1: return ObjetoAtual.getNomeDoCurso();
                   case 2: return ObjetoAtual.getTipoDoCurso();
                   case 3: return ObjetoAtual.getCargaHoraria();
                   case 4: return ObjetoAtual.getCodigoInstituicao();
               }
               return void.class;
        }

        @Override
        public void setValueAt(Object o, int i, int i1) {
        }

        @Override
        public void addTableModelListener(TableModelListener tl) {
            
        }

        @Override
        public void removeTableModelListener(TableModelListener tl) {
           
        }
        
    void setLista(List<ListElementosTable> lista) {
        this.lista = lista;
    }
    
   
    
}
