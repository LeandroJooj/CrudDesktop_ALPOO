/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javajdbc1;

/**
 *
 * @author george
 */
public class ListaTitulo {
    public String CodCurso;
    public String NomeCurso;
    public String tipoDeCurso;
    public String CargaHoraria;   
    public String CodInstituicao;
    
       public ListaTitulo(
                    String CodCurso, 
                    String NomeCurso, 
                    String tipoDeCurso,
                    String CargaHoraria, 
                    String CodInstituicao) 
    {
          this.CodCurso = CodCurso;
          this.NomeCurso = NomeCurso;
          this.tipoDeCurso = tipoDeCurso;
          this.CargaHoraria = CargaHoraria;
          this.CodInstituicao = CodInstituicao;
    }
    
    public String getCodCurso(){
        return CodCurso;
    }

    
    public String getNomeDoCurso(){
        return NomeCurso;
    }
    
    
    public String getTipoDoCurso(){
        return tipoDeCurso;
    }

    
    public String getCargaHoraria(){
        return CargaHoraria;
    }
    
    
    public String getCodigoInstituicao(){
        return CodInstituicao; 
    }
}