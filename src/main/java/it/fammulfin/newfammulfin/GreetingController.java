package it.fammulfin.newfammulfin;

import it.fammulfin.newfammulfin.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author "Eric Medvet" on 2022/01/02 for new-fammulfin
 */
@RestController
public class GreetingController {
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting get(@RequestParam(value = "name") String name) {
    return new Greeting(counter.incrementAndGet(), String.format("Hello %s!", name));
  }
}
