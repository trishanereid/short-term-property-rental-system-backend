package com.zenluxurystays.short_term_property_rental_system_backend.config;

import com.zenluxurystays.short_term_property_rental_system_backend.entity.User;
import com.zenluxurystays.short_term_property_rental_system_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User details not found for the user: " + username));

        List<SimpleGrantedAuthority> authorities = user.getAuthorities()
                .stream().map(authority ->
                        new SimpleGrantedAuthority(authority.getName()))
                .toList();

        return new org.springframework.security.core.userdetails
                .User(user.getEmail(), user.getPassword(), authorities);
    }
}
