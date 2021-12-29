package com.msa.user.config;

import com.msa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.Filter;

//@Configuration
public class WebSecurity   {


//    private UserService userService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    private Environment env;
//
//    @Autowired
//    public WebSecurity(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder,Environment env) {
//        this.userService = userService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.env=env;
//    }
//
//    public WebSecurity(boolean disableDefaults, UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        super(disableDefaults);
//        this.userService = userService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
////        http.authorizeRequests().antMatchers("/health_check/**").permitAll();
//        http.authorizeRequests().antMatchers("/**").hasIpAddress("localhost")
//                        .and()
//                .addFilter(AuthenticationFilter());
//
//        http.headers().frameOptions().disable();//h2-console을 보기 위해서
//
//    }
//
//    private Filter AuthenticationFilter() throws Exception {
//
//        AuthenticationFilter authenticationFilter = new AuthenticationFilter();
//        authenticationFilter.setAuthenticationManager(authenticationManager());//security manager check
//        return authenticationFilter;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
//    }
}
