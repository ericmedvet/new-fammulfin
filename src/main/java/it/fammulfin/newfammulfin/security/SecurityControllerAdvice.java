package it.fammulfin.newfammulfin.security;

import it.fammulfin.newfammulfin.entity.User;
import it.fammulfin.newfammulfin.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author "Eric Medvet" on 2022/01/05 for new-fammulfin
 */
@ControllerAdvice
public class SecurityControllerAdvice {
  private static final Logger L = LoggerFactory.getLogger(SecurityControllerAdvice.class);

  @Autowired
  private UserRepository userRepository;

  @ModelAttribute
  public LoggedUser customPrincipal(Authentication authentication) {
    if (authentication == null) {
      return null;
    }
    User user = userRepository.findByEmail(authentication.getName());
    if (user == null) {
      L.warn(String.format("Authenticated user '%s' not found", authentication.getName()));
      return null;
    }
    return new LoggedUser(authentication.getName(), user);
  }
}