package DAO;

import java.sql.Connection;
import java.util.List;
import javajdbc1.ListElementosTable;

/**
 *
 * @author george
 */
public interface AtrDados {
    public ListElementosTable getPorCod(int Cod) throws DadosException;
    
    public ListElementosTable getTudo() throws DadosException;
    
    public ListElementosTable getCurso() throws DadosException;
    
    public void incluir(ListElementosTable atividade) throws DadosException;
    
    public void excluir(ListElementosTable atividade) throws DadosException;
    
    public void atualizar(ListElementosTable atividade) throws DadosException;
    
}
