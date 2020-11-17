package com.clases;

public class BeneficiosCovid19 {
    //Debe ser el numero entero aleatorio puedes usar la funcion ramdom para esto
    private String id;
    private String nombre;
    private Float valorSubsidio;

    //Este es un constructor
    public BeneficiosCovid19(String nombre, Float valorSubsidio){
        this.id = getIdBeneficio();
        this.nombre = nombre;
        this.valorSubsidio = valorSubsidio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getValorSubsidio() {
        return valorSubsidio;
    }

    public void setValorSubsidio(Float valorSubsidio) {
        this.valorSubsidio = valorSubsidio;
    }

    private String getIdBeneficio(){
        //La Clase Math tiene varios metodos que te ayudaran
        this.id = String.valueOf(Math.floor(Math.random()*1000));
        return this.id;
    }

    @Override
    public String toString() {
        return "BeneficiosCovid19{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", valorSubsidio=" + valorSubsidio +
                '}';
    }
}
