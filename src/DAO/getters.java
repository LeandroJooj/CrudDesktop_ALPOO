/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javajdbc1.ListElementosTable;
import javajdbc1.NomeDoCurso;
import javajdbc1.TipoCurso;

/**
 *
 * @author george
 */
public class getters {
    
    
    private static final String SQL_SELECT_POR_COD
            = "SELECT CodCurso, NomeCurso, TipoCurso, CargaHoraria, CodInstituicao "
            + " FROM TB_ELEMENTOS WHERE CodCurso=?;";

        //get por codigo de curso
    public static ListElementosTable getPorCod(int Cod)  {
        Connection connection = Connect.GetConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ListElementosTable atividade = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_POR_COD);
            statement.setInt(1, Cod);
            rs = statement.executeQuery();
            if (rs.next()) { //se tiver registro
                int CodCurso = rs.getInt("CodCurso");
                String nomeStr = rs.getString("NomeCurso");
                NomeDoCurso NomeCurs = NomeDoCurso.valueOf(nomeStr);
                String tipoStr = rs.getString("TipoCurso");
                TipoCurso tipo = TipoCurso.valueOf(tipoStr);
                int carga = rs.getInt("CargaHoraria");
                int CodInst = rs.getInt("CodInstituicao");
                
                atividade = new ListElementosTable(CodCurso, NomeCurs,tipo, carga, CodInst); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Connect.fechar(connection, statement, rs);
        }
        return atividade;
    }
    
    private static final String SQL_SELECT_ALL
            = "SELECT CodCurso, NomeCurso, TipoCurso, CargaHoraria, CodInstituicao "
            + " FROM TB_ELEMENTOS;";
    
    public static List<ListElementosTable> getTudo() {
        Connection connection = Connect.GetConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<ListElementosTable> listaAtividades = new ArrayList<>();
      
        try {
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            rs = statement.executeQuery();
            if (rs.next()) { //se tiver registro
                int CodCurso = rs.getInt("CODIGO_DO_CURSO");
                String nomeStr = rs.getString("NOME");
                NomeDoCurso NomeCurs = NomeDoCurso.valueOf(nomeStr);
                String tipoStr = rs.getString("TIPO_DE_CURSO");
                TipoCurso tipo = TipoCurso.valueOf(tipoStr);
                int carga = rs.getInt("CARGA_HORARIA");
                int CodInst = rs.getInt("CODIGO_INSTITUICAO");
                ListElementosTable atividade = new ListElementosTable(CodCurso, NomeCurs,tipo, carga, CodInst); 
                listaAtividades.add(atividade);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Connect.fechar(connection, statement, rs);
        }
        return listaAtividades;
    }
    
        
    private static final String SQL_SELECT_CURSO
            = "SELECT NomeCurso "
            + " FROM TB_ELEMENTOS;";
    
    public static ListElementosTable getCurso() {
        Connection connection = Connect.GetConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ListElementosTable atividade = null;
        try {
            statement = connection.prepareStatement(SQL_SELECT_CURSO);
            rs = statement.executeQuery();
            if (rs.next()) { //se tiver registro
                int CodCurso = rs.getInt("CodCurso");
                String nomeStr = rs.getString("NomeCurso");
                NomeDoCurso NomeCurs = NomeDoCurso.valueOf(nomeStr);
                String tipoStr = rs.getString("TipoCurso");
                TipoCurso tipo = TipoCurso.valueOf(tipoStr);
                int carga = rs.getInt("CargaHoraria");
                int CodInst = rs.getInt("CodInstituicao");
                                        
                
                atividade = new ListElementosTable(CodCurso, NomeCurs,tipo, carga, CodInst); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Connect.fechar(connection, statement, rs);
        }
        return atividade;
    }
    
    private static final String SQL_INSERT
            = "INSERT INTO TB_ELEMENTOS (CodCurso, NomeCurso, TipoCurso, CargaHoraria, CodInstituicao) "
            + "VALUES (?, ?, ?, ?, ?);";
    public static void incluir(ListElementosTable eleme) throws SQLException  {
        Connection connection = Connect.GetConnection();
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, eleme.getCodCurso());
            statement.setString(2, eleme.getNomeDoCurso().name());
            statement.setString(3, eleme.getTipoDoCurso().name());
            statement.setInt(4, eleme.getCargaHoraria());
            statement.setInt(5, eleme.getCodigoInstituicao());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Connect.fechar(connection, statement);
        }
    }
    private static final String SQL_DELETE
            = "DELETE FROM TB_ATIVIDADES WHERE CodCurso = ?;";    
    
    public static void excluir(ListElementosTable elem) {
        Connection connection = Connect.GetConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE);
            statement.setInt(1, elem.getCodCurso());
            int qtdeRegistros = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Connect.fechar(connection, statement);
        }
    }

    //Mostrar
    
    private static final String SQL_UPDATE
            = "UPDATE TB_ELEMENTOS SET CodCurso = ?, NomeCurso = ? , TipoCurso = ? , CargaHoraria = ? , CodInstituicao= ?;";
                                      //1               2            3           4            5                  
    public static void atualizar(ListElementosTable eleme){
        Connection connection = Connect.GetConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setInt(1, eleme.getCodCurso());
            statement.setString(2, eleme.getNomeDoCurso().name());
            statement.setString(3, eleme.getTipoDoCurso().name());
            statement.setInt(4, eleme.getCargaHoraria());
            statement.setInt(5, eleme.getCodigoInstituicao());
            statement.executeUpdate();
        } catch (SQLException ex) {
               ex.printStackTrace();
        } finally {
            Connect.fechar(connection, statement);
        }
    }

    
        private static final String SQL_SELECT_POR_TIPO
            = "SELECT CodCurso, NomeCurso, TipoCurso, CargaHoraria, CodInstituicao "
            + " FROM TB_ELEMENTOS WHERE TipoCurso = ?;";

  
    public static List<ListElementosTable> getPorTipo(TipoCurso tipo) throws DadosException, SQLException {
        Connection connection = Connect.GetConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
    List<ListElementosTable> listaAtividades = new ArrayList<>();
        try {
         statement = connection.prepareStatement(SQL_SELECT_ALL);
         rs = statement.executeQuery();
            while (rs.next()) { //CodCurso, NomeCurso, TipoCurso, CargaHoraria, CodInstituicao
                int codigocurso = rs.getInt("CodCurso");
                String nomecursoStr = rs.getString("NomeCurso");
                NomeDoCurso nomecurso = NomeDoCurso.valueOf(nomecursoStr);
                String tipocursoStr = rs.getString("TipoCurso");
                TipoCurso tipocurso = TipoCurso.valueOf(tipocursoStr);
                int cargahoraria = rs.getInt("CargaHoraria");
                int codinstituicao = rs.getInt("CodInstituicao");
                ListElementosTable eleme   = new ListElementosTable(codigocurso, nomecurso, tipocurso, cargahoraria, codinstituicao);
                listaAtividades.add(eleme);
            }
        } catch (SQLException ex) {
            throw new DadosException(
                    "Não foi possivel selecionar", ex);
        } finally {
            Connect.fechar(connection, statement, rs);
        }
        return listaAtividades;
    }
    
    
    private static getters instance;
    
    public static getters getInstance() {
        if (instance == null) {
            instance = new getters();
        }
        return instance;
    }
    
}
/*
                Integer codigocurso = rs.getInt("CodCurso");
                NomeDoCurso nomecurso = rs.getString("NomeCurso");
                Date tipocurso = rs.getDate("TipoCurso");
                int qtde = rs.getInt("QTDE_HORAS");
                String cargahoraria = rs.getString("CargaHoraria");
                String codinstituicao = rs.getString("CodInstituicao");
                Situacao situacao = Situacao.valueOf(situacaoStr);
                ListElementosTable eleme   = new ListElementosTable(codigocurso, nomecurso, tipocurso, cargahoraria, codinstituicao);
                listaAtividades.add(eleme);
*/