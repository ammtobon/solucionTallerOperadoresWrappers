package com.clientes;

import com.clases.BeneficiosCovid19;
import com.clases.Mensajes;

import javax.sound.midi.Soundbank;
import javax.xml.crypto.Data;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<BeneficiosCovid19> listaBeneficios = new ArrayList<BeneficiosCovid19>();

        String nomBenef = null;
        Float valorBen = null;
        int indicador = 0;
        String swEnt = "SI";
        String valor = null;

        System.out.println(Mensajes.MSG1);

        // Implementar el ciclo para llenar la lista
        while (swEnt.equals("SI"))
        {
            if (swEnt.equals("SI") && indicador == 0 || indicador == 1)
            {
                System.out.println(Mensajes.BENEFICIO);
                valor = scn.nextLine();
                if (valor.trim().equals("")){
                    indicador = 1;
                    System.out.println(Mensajes.NOBENE);
                }
                else {
                    nomBenef = valor.toString();
                    indicador = 0;
                }
            }
            if (indicador == 0 || indicador == 2){
                System.out.println(Mensajes.VRBENEF);
                valor = scn.nextLine();
                if (isNumeric(valor)){
                    valorBen = Float.parseFloat(valor);
                    indicador = 0;
                }
                else{
                    indicador = 2;
                    System.out.println(Mensajes.NONUMERO);
                }
            }
            if (indicador == 0){
                // Se crea un objeto de tipo Beneficios Covid19
                BeneficiosCovid19 lstBen = new BeneficiosCovid19(nomBenef, valorBen);
                listaBeneficios.add(lstBen);
                System.out.println(lstBen);

                System.out.println(Mensajes.MSG2);
                swEnt = scn.nextLine().toUpperCase();
            }
        }
        System.out.println(Mensajes.MSG3 + getMejorbeneficios(listaBeneficios));
        scn.close();
    }

    public static Float getMejorbeneficios(List<BeneficiosCovid19> listaBeneficios){
        float mejorBenef = 0;

        for (int i=0; i<listaBeneficios.size(); i++){
            if (listaBeneficios.get(i).getValorSubsidio() > mejorBenef){
                BeneficiosCovid19 beneficio = listaBeneficios.get(i);
                mejorBenef = beneficio.getValorSubsidio();
            }
        }
        return Float.valueOf(mejorBenef);
    }

    public static void listaBeneficio(List<BeneficiosCovid19> listaBeneficios){
        for (BeneficiosCovid19 beneficio : listaBeneficios){
            System.out.println(beneficio);
        }
    }

    public static boolean isNumeric(String value) {
        boolean valorNumerico;
        try {
            Double.parseDouble(value);
            valorNumerico = true;
        }
        catch (NumberFormatException e){
            valorNumerico = false;
        }
        return valorNumerico;
    }
}
