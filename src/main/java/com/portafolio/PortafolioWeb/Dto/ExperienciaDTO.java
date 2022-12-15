package com.portafolio.PortafolioWeb.Dto;


public class ExperienciaDTO {
    private String nombreExp;
    private String descripcionExp;

    public ExperienciaDTO() {
    }

    public ExperienciaDTO(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }

    
    public String getNombreExp() {
        return nombreExp;
    }
    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }
    public String getDescripcionExp() {
        return descripcionExp;
    }
    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }
    
    

    
}
