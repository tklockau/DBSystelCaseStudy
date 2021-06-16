/**
 * BetriebsstellenRepository stellt die Schnittstelle zu den Betriebsstellen dar.
 * 
 * AUTOR: Tobias Klockau
 */

package tklockau.betriebsstellenapi.betriebsstellenapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BetriebsstellenRepository extends JpaRepository<Betriebsstelle, String>{
    
}
