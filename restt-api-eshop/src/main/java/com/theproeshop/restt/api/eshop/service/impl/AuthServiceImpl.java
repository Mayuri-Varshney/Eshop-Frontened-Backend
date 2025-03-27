package com.theproeshop.restt.api.eshop.service.impl;

import com.theproeshop.restt.api.eshop.entity.Role;
import com.theproeshop.restt.api.eshop.entity.User;
import com.theproeshop.restt.api.eshop.exception.AuthException;
import com.theproeshop.restt.api.eshop.payload.LoginDto;
import com.theproeshop.restt.api.eshop.payload.RegisterDto;
import com.theproeshop.restt.api.eshop.repository.RoleRepository;
import com.theproeshop.restt.api.eshop.repository.UserRepository;
import com.theproeshop.restt.api.eshop.security.JwtTokenProvider;
import com.theproeshop.restt.api.eshop.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        System.out.println(token);
        return token;
    }
    @Override
    public String register(RegisterDto registerDto) {
        // check for username exist in database
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new AuthException(HttpStatus.BAD_REQUEST, "Username is already taken!");
        }

        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new AuthException(HttpStatus.BAD_REQUEST, "Email is already taken!");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(registerDto.getRole()).get();
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);
        return "User registered successfully!";
    }
    @Override
    public String createRole(Role role) {
        roleRepository.save(role);
        return "Role created successfully!";
    }
    @Override
    public String deleteRole(String name) {
        roleRepository.deleteByName(name);
        return "Role deleted successfully!";
    }
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
    @Override
    public String getRoleByName(String name) {
        return roleRepository.findByName(name).get().getName();

    }
}
