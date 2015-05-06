/**
 * 
 */
package com.roadtobe.supaldubey.examples.spring.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author Supal
 * 
 */
public class SampleAuthProvider implements AuthenticationProvider
{
    @Override
    public boolean supports(Class<? extends Object> authentication)
    {
	return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    private static Map<String, String> SIMPLE_USERS = new HashMap<String, String>(2);
    private static List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
    static
    {
	SIMPLE_USERS.put("supaldubey", "roadtobe");
	SIMPLE_USERS.put("supal", "roadtobe");
	AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ADD"));
    }

    @Override
    public Authentication authenticate(Authentication auth)
    {
	if (SIMPLE_USERS.containsKey(auth.getPrincipal())
		&& SIMPLE_USERS.get(auth.getPrincipal()).equals(auth.getCredentials()))
	{
	    return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(),
		    AUTHORITIES);
	}
	throw new BadCredentialsException("Username/Password does not match for "
		+ auth.getPrincipal());
    }
}
