package com.norofff.team1.footballapi.config;


import com.norofff.team1.footballapi.repository.Users_Repository;
import com.norofff.team1.footballapi.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableJpaRepositories(basePackageClasses = Users_Repository.class)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

                /*httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/index*","/static/**", "/*.json", "/*.ico")
                .permitAll()
                .anyRequest().authenticated()
                        .and()
                        .formLogin().loginPage("/index.html")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/homepage.html",true)
                        .failureUrl("/index.html?error=true");*/
        /*httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/test").hasRole("USER")
                .anyRequest()
                .permitAll()
                .and().formLogin()
                //.loginPage("/users/login")
                .permitAll().and().httpBasic();*/
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/test").permitAll()
                .and().httpBasic();
    }

   /*@Override
   protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
               .antMatchers("/bower_components/**", "/*.js",
                       "/*.jsx", "/main.css").permitAll()
               .anyRequest().authenticated()
               .and()
               .formLogin()
               .defaultSuccessUrl("/", true)
               .permitAll()
               .and()
               .httpBasic()
               .and()
               .csrf().disable()
               .logout()
               .logoutSuccessUrl("/");
   }*/

   /* @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","OPTIONS","DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }*/

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
