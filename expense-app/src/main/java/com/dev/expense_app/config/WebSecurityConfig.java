//package com.dev.expense_app.config;
//
//import org.jetbrains.annotations.NotNull;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//
//
//public class WebSecurityConfig {
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception{
////        http
////                .csrf().disable()
////                .authorizeRequests()
////                .antMatchers("/login","/register").permitAll()
////                .anyReqeust().authenticated()
////                .and()
////                .httpBasic();
////    }
//    @Bean
//    public DefaultSecurityFilterChain filterChain(@NotNull HttpSecurity http) throws Exception{
//        http
//                .csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/login","/register").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//        return http.build();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
////        auth.inMemoryAuthentication()
////                .withUser("bushan").password("12345").authorities("admin")
////                .and()
////                .withUser("bharath").password("12345").authorities("user")
////                .and()
////                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user1 = User.withUsername("bushan").password("12345").authorities("admin").build();
//        UserDetails user2 = User.withUsername("bharath").password("12345").authorities("user").build();
//
//        auth.userDetailsService(userDetailsManager);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//}
