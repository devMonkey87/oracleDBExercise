package com.example.implementacionApiRest.security;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

import com.example.implementacionApiRest.auth.JWTFilter.JWTAuthenticationFilter;
import com.example.implementacionApiRest.auth.JWTFilter.JWTAuthorizationFilter;
import com.example.implementacionApiRest.auth.serviceJWT.JWTService;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private JWTService jwtService;
	
	
	
	
	@Value("${ldap.userDNPattern:}")
	private String userDNPattern;

	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(SecurityConfig.class.getName());

	// @Value("${ldap.urls}")
	// private String ldapUrls;
	//
	// @Value("${ldap.base.dn}")
	// private String ldapBaseDn;
	//
	// @Value("${ldap.username}")
	// private String ldapSecurityPrincipal;
	//
	// @Value("${ldap.password}")
	// private String ldapPrincipalPassword;
	//
	// @Value("${ldap.user.dn.pattern}")
	// private String ldapUserDnPattern;
	//
	// @Value("${ldap.enabled}")
	// private String ldapEnabled;

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http
	// .authorizeRequests()
	// .antMatchers("/api/login**").permitAll()
	// .antMatchers("/api/funciones").fullyAuthenticated()
	// //.antMatchers("/profile/**").fullyAuthenticated()
	// .antMatchers("/").permitAll()
	// .and()
	// .formLogin()
	// .loginPage("/api/login")
	// .failureUrl("/api/login?error")
	// .permitAll()
	// .and()
	// .logout()
	// .invalidateHttpSession(true)
	// .deleteCookies("JSESSIONID")
	// .permitAll();
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers("/api/login**").permitAll()
		.antMatchers("/api/funciones").fullyAuthenticated()
		.antMatchers("/").permitAll()
		.and().formLogin()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))
		.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtService))
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		
//		 http
//		 .authorizeRequests()
//		 .antMatchers("/api/login**").permitAll()
//		 .antMatchers("/api/funciones").fullyAuthenticated()
//		 //.antMatchers("/profile/**").fullyAuthenticated()
//		 .antMatchers("/").permitAll()
//		 .and()
//		 .formLogin()
//		 .loginPage("/api/login")
//		 .failureUrl("/api/login?error")
//		 .permitAll()
//		 .and()
//		 .logout()
//		 .invalidateHttpSession(true)
//		 .deleteCookies("JSESSIONID")
//		 .permitAll();
		
		
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// if(Boolean.parseBoolean(ldapEnabled)) {
		// auth
		// .ldapAuthentication()
		// .contextSource()
		// .url(ldapUrls + ldapBaseDn)
		// .managerDn(ldapSecurityPrincipal)
		// .managerPassword(ldapPrincipalPassword)
		// .and()
		//
		// //.userSearchFilter(ldapUserDnPattern);
		// .userDnPatterns(ldapUserDnPattern);
		//
		// if (logger.isInfoEnabled()) {
		// logger.error(" AUTENTICACIÓ PER PROPERTIES"); //$NON-NLS-1$
		// }
		//
		// } else {
		// auth
		// .inMemoryAuthentication()
		// .withUser("CN=BBRMVB,OU=GSA,DC=xx,DC=xx,DC=xx").password("").roles("GSA");
		// //.and()
		// //.withUser("").password("").roles("");
		//
		// logger.error("AUTENTICACIÓ EN MEMORIA"); //$NON-NLS-1$
		//
		// }
		// }

//variables con los datos del dominio ADirectory y su URL

		String domain = "xx.xx.local";
		String url = "ldap://000.000.00.000:000";

		ActiveDirectoryLdapAuthenticationProvider adProvider = new ActiveDirectoryLdapAuthenticationProvider(domain,
				url);
		adProvider.setConvertSubErrorCodesToExceptions(true);
		adProvider.setUseAuthenticationRequestCredentials(true);

		// set pattern if it exists
		// The following example would authenticate a user if they were a member
		// of the ServiceAccounts group
		// (&(objectClass=user)(userPrincipalName={0})
		// (memberof=CN=ServiceAccounts,OU=alfresco,DC=mycompany,DC=com))
		if (userDNPattern != null && userDNPattern.trim().length() > 0) {
			adProvider.setSearchFilter(userDNPattern);
		}
		auth.authenticationProvider(adProvider);

		// don't erase credentials if you plan to get them later
		// (e.g using them for another web service call)
		auth.eraseCredentials(false);

	}

}
