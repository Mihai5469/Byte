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

        if (!isBinary(bits) && bits.length() > 8) {
            System.err.println("La stringa non soddisfa i criteri per essere un byte");
            return;
        }
        this.bits = "";
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
     * Metodo che ritorna la sequenza di bit invertita
     * @return sequenza di bit invertita (String)
     */
    public String inverti(){
        String s = "";
        for (int i = bits.length() -1; i >= 0; i--) {
            s += bits.charAt(i);
        }
        return s;
    }


    /**
     * Metodo che controlla se la stringa non e piu
     * lunga di 8 caratteri e se e composta solo da '0' e '1'
     * @param bits Stringa da verificare
     * @return true se tute le condizioni sono soddisfate
     */
    private boolean isBinary(String bits) {
//        if(bits.length() > 8){
//            return false;
//        }
        for(int i = 0; i < bits.length(); i++){
            if(!(bits.charAt(i) == '1' || bits.charAt(i) == '0')){
                return false;
            }
        }
        return true;
    }

    /**
     * Setter
     * @param bits insieme di bit
     */
    public void setBits(String bits) {
        if (!isBinary(bits)){
            System.err.println("La stringa non soddisfa i criteri per essere un byte");
            return;
        }
        this.bits = bits;
    }

    /**
     * Getter
     * @return bits insieme di bit
     */
    public String getBits() {
        return bits;
    }

    /**
     * Metodo che ritorna la cifra piu significativa nell'insieme di bit
     * @return n Cifra piu significativa
     */
    public int cifraPS(){
        int n = 0;
        boolean v = true;
        for (int i = 0; i < bits.length() && v; i++) {
            if(bits.charAt(i) == '1'){
                n = 7 - i;
                v = false;
            }
        }
        return n;
    }


    /**
     * Metodo che ritorna la cifra Meno significativa nell'insieme di bit
     * @return 0 e sempre la meno significativa
     */
    public int cifraMS(){
        return 0;
    }


    @Override
    public String toString() {
        return bits;
    }
}
