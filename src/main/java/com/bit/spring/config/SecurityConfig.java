package com.bit.spring.config;
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig { //extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER")
//                .and().withUser("admin").password("{noop}admin123").roles("USER", "ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.httpBasic().and().authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/lista/**").hasRole("USER")
//                .antMatchers(HttpMethod.GET, "/zapato/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/catalogo").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/home/**").hasRole("USER")
//                .and().csrf().disable().formLogin().disable();
//    }

}
