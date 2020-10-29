/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javajdbc1;

import java.util.ArrayList;
import java.util.List;

/*
     private String CodCurso;
    private NomeDoCurso NomeCurso;
    private TipoCurso tipoDeCurso;
    private int CargaHoraria;   
    private int CodInstituicao;
 
 */
public class PegaDado{
    
    List<ListElementosTable> elementos;
    private static int contador = 1;

    
    public static List<ListElementosTable> genElemTable(){
     ListElementosTable elementos =  new ListElementosTable(122, NomeDoCurso.Direito, TipoCurso.GESTAO, 20, 10);
     List<ListElementosTable> listaDeElemen = new ArrayList<>();
     listaDeElemen.add(elementos);
     return listaDeElemen;
    }
    
        public static List<ListaTitulo> genElemTableTabel1(){
     ListaTitulo elementos =  new ListaTitulo("Cód","curso","Tipo","tempo","Cód.instituto");
     List<ListaTitulo> listaDeElemen = new ArrayList<>();
     listaDeElemen.add(elementos);
     return listaDeElemen;
    }
    
     public void incluir(ListElementosTable elem){ //throws DadosException {
        if (elem != null) {
            elem.setCodCurso(contador++);
            elementos.add(elem);
        } else {
            System.err.print("erro");
        }
    }

    public void atualizar(ListElementosTable elem)  {
        if (elem != null) {
            for (ListElementosTable atividadeAtual : elementos) {
                if (atividadeAtual.getCodCurso()== elem.getCodCurso()) {
                    int indice = elementos.indexOf(atividadeAtual);
                    elementos.set(indice, elem);
                    break;
                }
            }
        } else {
            System.err.println("Atividade nula");
        }
    }

    public void excluir(ListElementosTable elem) {
        if (elem != null) {
            elementos.remove(elem);
        } else {
            System.err.println("erro");
        }
    }
    
    
    
}
