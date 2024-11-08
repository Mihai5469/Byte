package org.es;

/**
 * Classe Byte intesa come sequenza di bit con le seguenti funzionalità:
 * - costruttori vari;
 * - metodo decimale(...) che converte la sequenza in un numero decimale;
 * - metodo inverti(...) che inverte la sequenza binaria
 * - metodo cifraPS () restituisce la cifra binaria più significativa della sequenza;
 * - metodo cifraMS () restituisce la cifra binaria meno significativa della sequenza;
 * - metodo isBinary() restituisce True se la sequenza contiene solo 1 o 0, se contiene altri
 *   caratteri restituisce False.
 *
 * @author Mihai
 * @version 07/11/2024
 */

public class Byte {
    private String bits;

    /**
     * Costruttore con un parametro in caso che la stringa e piu lunga di
     * 8 caratteri o contiene altri caratteri tranne '0' e '1'
     * da errore
     * @param bits stringa che representa la sequenza di bit
     */
    public Byte(String bits) {
        this.bits = "";
        if (!controllo(bits)){
            System.err.println("La stringa non soddisfa i criteri per essere un byte");
            return;
        }

        if(bits.length() < 8){
           int n = 8 - bits.length();
           for (int i = 0; i < n; i++) {
               this.bits += "0";
           }
        }
        this.bits += bits;
    }

    /**
     * Costruttore di copia
     * @param byt oggetto da copiare
     */
    public Byte(Byte byt){
        this.bits = byt.bits;
    }


    /**
     * Metodo che converte la stringa di bit in numero decimale
     * @return n numero decimale
     */
    public int decimale(){
        int n = 0;
        for (int i = 0; i < bits.length(); i++) {
//            int sup = Integer.parseInt(bits.charAt(i) + "");
//            System.out.println(sup);
            n += Integer.parseInt(bits.charAt(i) + "") * Math.pow(2, 7 - i);
//            System.out.println("z = " + (7-i));
        }
        return n;
    }

    /**
     * Metodo che converte una stringa di bit in numero decimale.
     * Se la stringa non inserito nel formato richiesto ritorna il valore '-1'
     * @param bits stringa di bit
     * @return n numero decimale, -1 se non e coretto
     */
    public static int decimale(String bits){
        Byte b = new Byte(bits);
        if(b != null){
            return b.decimale();
        }
        return -1;
    }


    /**
     * Metodo che controlla se la stringa non e piu
     * lunga di 8 caratteri e se e composta solo da '0' e '1'
     * @param bits Stringa da verificare
     * @return true se tute le condizioni sono soddisfate
     */
    private boolean controllo(String bits) {
        if(bits.length() > 8){
            return false;
        }
        for(int i = 0; i < bits.length(); i++){
            if(!(bits.charAt(i) == '1' || bits.charAt(i) == '0')){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return bits;
    }
}
