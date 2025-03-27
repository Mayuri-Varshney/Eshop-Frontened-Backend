package com.theproeshop.rest.api.eshop.service;

import com.theproeshop.rest.api.eshop.entity.Role;
import com.theproeshop.rest.api.eshop.payload.LoginDto;
import com.theproeshop.rest.api.eshop.payload.RegisterDto;

import java.util.List;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    String createRole(Role role);
    String deleteRole(String name);
    List<Role> getAllRoles();
    String getRoleByName(String name);

}
