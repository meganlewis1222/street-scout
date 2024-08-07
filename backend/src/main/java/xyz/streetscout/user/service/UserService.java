package xyz.streetscout.user.service;

import xyz.streetscout.user.dto.LoginRequest;
import xyz.streetscout.user.dto.Register;
import xyz.streetscout.user.dto.Response;

public interface UserService {
    String register(Register register);

    Response login(LoginRequest loginRequest) throws Exception;
}
