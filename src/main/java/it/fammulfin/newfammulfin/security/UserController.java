package it.fammulfin.newfammulfin.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Eric Medvet" on 2022/01/05 for new-fammulfin
 */
@RestController
public class UserController {
  @GetMapping("/username")
  public LoggedUser username(@ModelAttribute LoggedUser loggedUser) {
    return loggedUser;
  }
}
