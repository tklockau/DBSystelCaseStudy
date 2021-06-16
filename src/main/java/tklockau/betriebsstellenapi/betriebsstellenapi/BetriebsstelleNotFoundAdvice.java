/**
 * BetriebsstelleNotFoundAdvice gibt die BetriebsstelleNotFoundException an den Benutzer anstelle 
 * eines 404 Fehlercodes aus, falls eine nicht vorhandene Betriebsstelle abgefragt wird.
 * 
 * AUTOR: Tobias Klockau
 */

package tklockau.betriebsstellenapi.betriebsstellenapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class BetriebsstelleNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(BetriebsstelleNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String BetriebsstelleNotFoundHandler(BetriebsstelleNotFoundException e) {
    return e.getMessage();
  }
}
