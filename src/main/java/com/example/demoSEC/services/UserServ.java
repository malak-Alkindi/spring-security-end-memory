package com.example.demoSEC.services;


import com.example.demoSEC.model.AppUser;
import com.example.demoSEC.repstry.userRep;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServ  implements UserDetailsService {

    private final userRep userrep;
  private final PasswordEncoder passwordEncoder;
    public List<AppUser> findAll (){

        return userrep.findAll();
    }

    public AppUser findById (Long id){

        return userrep.findById(id).orElse(null);
    }

    public AppUser save(AppUser entity) {
       entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        return userrep.save(entity);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AppUser> appUser =	userrep.findByUserName(username);

        if (!appUser.isPresent()) {

            throw new UsernameNotFoundException("This User Not found with selected user name :- " + username);
        }

        return new User(appUser.get().getUserName(),appUser.get().getPassword(),getAuthorities(appUser.get()));


    }
    	private static List<GrantedAuthority> getAuthorities(AppUser user) {

		List<GrantedAuthority> authorities = new ArrayList<>();

		 if(!user.getRoles().isEmpty()) {
		        	user.getRoles().forEach(role -> {
		        		authorities.add(new SimpleGrantedAuthority(role.getName()));
		        	});
		        }
		     return authorities;
		}

}
