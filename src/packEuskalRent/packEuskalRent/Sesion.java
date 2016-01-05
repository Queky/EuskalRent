/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packEuskalRent;

/**
 *
 * @author BEEP
 */
public class Sesion {
    private static Sesion mSesion;
    private int numerosAceso = 0;
    private boolean esLaPrimeraVisita = true ;
    
    
       public static Sesion getSesion() {
        if (mSesion == null) {
            mSesion = new Sesion();
        }

        return mSesion;
    }
       public boolean acceso(){
       if(numerosAceso == 0){
       numerosAceso++;
       return true;
       }else{
       numerosAceso++;
       return false;
       }
       }
       public void reniciarSesion(){
       this.numerosAceso = 0;
       
       }
    
}
