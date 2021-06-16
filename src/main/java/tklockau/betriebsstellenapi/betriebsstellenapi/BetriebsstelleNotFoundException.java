/**
 * BetriebsstelleNotFoundException wird ausgelöset, wenn der Benutzer versucht eine nicht 
 * vorhandene Betriebsstelle abzufragen.
 * 
 * AUTOR: Tobias Klockau
 */

package tklockau.betriebsstellenapi.betriebsstellenapi;

public class BetriebsstelleNotFoundException extends RuntimeException {
    
    BetriebsstelleNotFoundException (String abk){
        super("[FEHLER] Die Betriebsstelle \"" + abk.toUpperCase() + "\" existiert nicht.");
    }
}