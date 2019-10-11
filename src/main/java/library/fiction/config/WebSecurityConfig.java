package library.fiction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
//                .and()
//                .authorizeRequests().antMatchers("/login**").permitAll()
//                .and()
//                .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/login").permitAll()
//                .and()
//                .csrf().disable();


                .authorizeRequests()
                .anyRequest().hasAnyRole("ROLE_ADMIN", "ROLE_USER")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/loginAction")
                .permitAll()
                .and()
                .logout()
                .deleteCookies("remove")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().csrf().disable();


//                .authorizeRequests().anyRequest().hasAnyRole("ROLE_ADMIN", "ROLE_USER")
//                .and().formLogin()
//                .loginPage("/login").failureUrl("/login?error")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .permitAll()
//                .and().logout().logoutSuccessUrl("/login?logout")
//                .permitAll()
//                .and().csrf()
//                .and().exceptionHandling().accessDeniedPage("/403");
    }

}
