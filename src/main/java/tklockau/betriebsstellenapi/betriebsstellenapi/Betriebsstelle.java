/**
 * Betriebsstelle repräsentiert jede Zeile in der CSV-Datei als Objekt und enthält alle hierfür 
 * notwendigen Informationen im JSON-Format. Die Klasse wird über die Abkürzung als String, mit 
 * den Inhalten der Tabellenzeile (ohne die erste Spalte) und der Titelzeile (ohne die erste 
 * Spalte) aufgerufen.
 * 
 * AUTOR: Tobias Klockau
 */

package tklockau.betriebsstellenapi.betriebsstellenapi;

import org.json.simple.JSONObject;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
class Betriebsstelle {

    private @Id String abk;

    @Lob
    private JSONObject json;

    Betriebsstelle(){}

    Betriebsstelle(
        String abk,
        String[] data,
        String[] titles
    ) throws IOException
    {
        // Übernimmt die Abkürzung
        this.abk = abk;

        // Erstellt das JSON-Objekt
        this.json = new JSONObject();

        this.json.put("Abk", this.abk);
        for (int i = 0; i < titles.length; i++){
            try{
                this.json.put(titles[i], data[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                this.json.put(titles[i], "");
            }
        }
    }

    public JSONObject getJson(){
        return this.json;
    }
}