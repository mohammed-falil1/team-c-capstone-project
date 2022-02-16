package com.collabera.account_management_system.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.LoginUser;
import com.collabera.account_management_system.repo.LoginAuthenticationRepo;
import com.collabera.account_management_system.utility.ApplicationConstants;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	LoginAuthenticationRepo loginAuthenticationRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LoginUser loginUser = loginAuthenticationRepo.findLoginByUserName(userName);
		ApplicationConstants.ACCOUNT_NUMBER=loginUser.getAccountNumber();
		return new MyUserDetails(loginUser);
	}

	

}
