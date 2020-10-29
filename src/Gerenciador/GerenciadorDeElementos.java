/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciador;

import DAO.AtrDados;
import DAO.DadosException;
import DAO.getters;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javajdbc1.ListElementosTable;
import javajdbc1.NomeDoCurso;
import javajdbc1.TipoCurso;


/**
 *
 * @author george
 */
public class GerenciadorDeElementos {
    //implementacao do Singleton
    private static GerenciadorDeElementos instance;

    private GerenciadorDeElementos() {
    }

    public static GerenciadorDeElementos getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeElementos();
        }
        return instance;
    }
    //implementacao do Singleton
    

    public ListElementosTable getNovoElemento(){
        ListElementosTable atividade = new ListElementosTable();
        atividade.setCodCurso(0);
        atividade.setNomeDoCurso(NomeDoCurso.Direito);
        atividade.setTipoDeCurso(TipoCurso.GESTAO);
        atividade.setCargaHoraria(0);
        atividade.setCodigoInstituicao(0);
        return atividade;
    }  
    public static void salvar(ListElementosTable elemen) throws SQLException{
        boolean ehNova = elemen != null && elemen.getCodCurso() != null
                && !(elemen.getCodCurso() > 0);
        if (ehNova) {
            getters.incluir(elemen);
        } else {
            getters.atualizar(elemen);
            
        }
    }

    public void excluir(ListElementosTable atividade){
        getters.excluir(atividade);
    }

    public static ListElementosTable getPorCod(Integer Cod){
        return getters.getPorCod(Cod);
    }

    public List<ListElementosTable> getTodas()  {
        return (List<ListElementosTable>) getters.getTudo();
    }
    
        public static List<ListElementosTable> getPorTipo(TipoCurso tipo) throws DadosException, SQLException {
        if (tipo != null) {
            return getters.getPorTipo(tipo);
        } else {
            return getters.getTudo();
        }

}
}

    

