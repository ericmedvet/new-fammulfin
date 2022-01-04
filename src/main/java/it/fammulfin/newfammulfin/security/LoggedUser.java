package it.fammulfin.newfammulfin.security;

import it.fammulfin.newfammulfin.entity.User;

/**
 * @author "Eric Medvet" on 2022/01/05 for new-fammulfin
 */
public record LoggedUser(String username, User user) {
}
