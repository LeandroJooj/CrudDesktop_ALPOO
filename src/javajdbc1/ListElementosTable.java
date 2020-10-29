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
public class ListElementosTable {
    public Integer CodCurso;
    public NomeDoCurso NomeCurso;
    public TipoCurso tipoDeCurso;
    public int CargaHoraria;   
    public int CodInstituicao;

    public ListElementosTable() {
    }

    public ListElementosTable(
                    Integer CodCurso, 
                    NomeDoCurso NomeCurso, 
                    TipoCurso tipoDeCurso,
                    int CargaHoraria, 
                    int CodInstituicao) 
    {
          this.CodCurso = CodCurso;
          this.NomeCurso = NomeCurso;
          this.tipoDeCurso = tipoDeCurso;
          this.CargaHoraria = CargaHoraria;
          this.CodInstituicao = CodInstituicao;
    }
    
    public Integer getCodCurso(){
        return CodCurso;
    }
    
    public void setCodCurso(int CodCurso){
        this.CodCurso = CodCurso;
    }
    
    public NomeDoCurso getNomeDoCurso(){
        return NomeCurso;
    }
    
    public void setNomeDoCurso(NomeDoCurso NomeCurso){
        this.NomeCurso = NomeCurso;
    }
    
    public TipoCurso getTipoDoCurso(){
        return tipoDeCurso;
    }
    
    public void setTipoDeCurso(TipoCurso tipoDeCurso){
        this.tipoDeCurso = tipoDeCurso;
    }
    
    public int getCargaHoraria(){
        return CargaHoraria;
    }
    
    public void setCargaHoraria(int CargaHoraria){
        this.CargaHoraria = CargaHoraria; 
    }
    
    public int getCodigoInstituicao(){
        return CodInstituicao; 
    }
    
    public void setCodigoInstituicao(int CodInstituicao){
        this.CodInstituicao = CodInstituicao; 
    }
   
}

