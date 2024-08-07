package xyz.streetscout.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.streetscout.customer.dto.CustomerProfile;
import xyz.streetscout.customer.service.CustomerService;
import xyz.streetscout.security.JwtUtils;
import xyz.streetscout.user.dto.LoginRequest;
import xyz.streetscout.user.dto.Register;
import xyz.streetscout.user.dto.Response;
import xyz.streetscout.user.entity.User;
import xyz.streetscout.user.repository.UserRepository;
import xyz.streetscout.vendor.dto.VendorDetails;
import xyz.streetscout.vendor.service.VendorService;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private final VendorService vendorService;

    private final CustomerService customerService;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    private final AuthenticationManager authenticationManager;

    @Override
    public String register(Register register){
        if (register.role() == "VENDOR") {
            User user = new User();
            user.setEmail(register.vendorRegistration().email());
            user.setRole(register.role());
            user.setPassword(passwordEncoder.encode(register.password()));
            User savedUser = userRepository.save(user);
            VendorDetails vendor = vendorService.registerVendor(register.vendorRegistration());
            return ("Registered successfully");
        } else if (register.role() == "CUSTOMER") {
            User user = new User();
            user.setEmail(register.vendorRegistration().email());
            user.setRole(register.role());
            user.setPassword(passwordEncoder.encode(register.password()));
            User savedUser = userRepository.save(user);
            CustomerProfile customerProfile=customerService.addCustomer(register.registerCustomer());
            return ("Registered successfully");
        } else{
            return new String("enter valid details");
    }
    }

    @Override
    public Response login(LoginRequest loginRequest) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));
        var user = userRepository.findByEmail(loginRequest.email()).orElseThrow(() -> new Exception("user Not found"));

        var token = jwtUtils.generateToken(user);
        if(user.getRole()=="VENDOR"){
            VendorDetails vendorDetails=vendorService.getVendorByEmail(user.getEmail());
        return new Response("Logged in successfully",token,vendorDetails,null);
        }
        else if(user.getRole()=="CUSTOMER"){
            CustomerProfile customerProfile=customerService.getCustomerProfileByEmail(user.getEmail());
            return new Response("Logged in successfully",token,null,customerProfile);}
        else{
            throw new Exception("User not found");
        }
    }
}
