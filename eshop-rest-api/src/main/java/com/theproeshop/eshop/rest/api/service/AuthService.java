package com.theproeshop.eshop.rest.api.service;

import com.theproeshop.eshop.rest.api.entity.Role;
import com.theproeshop.eshop.rest.api.payload.LoginDto;
import com.theproeshop.eshop.rest.api.payload.RegisterDto;

import java.util.List;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    String createRole(Role role);
    String deleteRole(String name);
    List<Role> getAllRoles();
    String getRoleByName(String name);

}
