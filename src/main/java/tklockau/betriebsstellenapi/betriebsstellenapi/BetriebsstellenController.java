/**
 * BetriebsstellenController verarbeitet die REST-Anfragen und gibt die Daten zurück.
 * 
 * AUTOR: Tobias Klockau
 */

package tklockau.betriebsstellenapi.betriebsstellenapi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetriebsstellenController {

  private final BetriebsstellenRepository repository;

  BetriebsstellenController(BetriebsstellenRepository repository) {
    this.repository = repository;
  }

  // Gibt alle Betriebsstellen zurück
  @GetMapping("/betriebsstelle")
  List<Betriebsstelle> all() {
    return repository.findAll();
  }

  // Gibt eine Betriebsstelle zurück
  @GetMapping("/betriebsstelle/{abk}")
  Betriebsstelle one(@PathVariable String abk) {
    
    return repository.findById(abk.toUpperCase())
        .orElseThrow(() -> new BetriebsstelleNotFoundException(abk));
  }
}