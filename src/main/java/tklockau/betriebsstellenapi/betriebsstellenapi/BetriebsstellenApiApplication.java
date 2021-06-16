/**
 * BetriebsstellenApiApplication ist die Ausführende Klasse für die API und startet die 
 * SpringApplication.
 * 
 * AUTOR: Tobias Klockau
*/

package tklockau.betriebsstellenapi.betriebsstellenapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BetriebsstellenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetriebsstellenApiApplication.class, args);
	}
}