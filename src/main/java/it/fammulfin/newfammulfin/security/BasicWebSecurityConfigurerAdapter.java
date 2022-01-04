package it.fammulfin.newfammulfin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author "Eric Medvet" on 2022/01/02 for new-fammulfin
 */
@Configuration
@EnableWebSecurity
public class BasicWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

  @Bean
  InMemoryUserDetailsManager userDetailsManager() {
    User.UserBuilder userBuilder = User.builder()
        .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode);
    return new InMemoryUserDetailsManager(
        userBuilder.username("alice@red.org").password("1234").roles("admin", "user").build(),
        userBuilder.username("bob@red.org").password("5678").roles("user").build()
    );
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/", "/greeting").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
  }
}
