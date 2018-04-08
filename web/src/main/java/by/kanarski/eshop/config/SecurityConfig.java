package by.kanarski.eshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import by.kanarski.eshop.security.JwtAuthenticationEntryPoint;
import by.kanarski.eshop.security.filters.JwtAuthenticationTokenFilter;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtAuthenticationEntryPoint unauthorizedHandler;
    private UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(JwtAuthenticationEntryPoint unauthorizedHandler, UserDetailsService userDetailsService) {
        this.unauthorizedHandler = unauthorizedHandler;
        this.userDetailsService = userDetailsService;
    }

    @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                    // we don't need CSRF because our token is invulnerable
                    .csrf().disable()

                    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

                    // don't create session
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                    .authorizeRequests()
                    //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                    // allow anonymous resource requests
                    .antMatchers("/").permitAll();

//                .antMatchers("/auth/**").permitAll()
//                .anyRequest().authenticated();

        // Custom JWT based security filter
//        httpSecurity.addFilter(new UsernamePasswordAuthenticationFilter());
        httpSecurity.addFilterBefore(methodFilter(), UsernamePasswordAuthenticationFilter.class);
//        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        httpSecurity.headers().cacheControl();

    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public HiddenHttpMethodFilter methodFilter() {
        return new HiddenHttpMethodFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
