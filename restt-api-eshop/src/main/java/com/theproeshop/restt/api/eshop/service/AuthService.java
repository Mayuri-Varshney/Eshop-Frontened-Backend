package com.theproeshop.restt.api.eshop.service;

import com.theproeshop.restt.api.eshop.entity.Role;
import com.theproeshop.restt.api.eshop.payload.LoginDto;
import com.theproeshop.restt.api.eshop.payload.RegisterDto;

import java.util.List;

public interface AuthService {
    String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    String createRole(Role role);
    String deleteRole(String name);
    List<Role> getAllRoles();
    String getRoleByName(String name);

}
