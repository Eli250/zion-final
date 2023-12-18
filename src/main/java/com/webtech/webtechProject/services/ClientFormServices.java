package com.webtech.webtechProject.services;

import com.webtech.webtechProject.model.ClientForm;
import com.webtech.webtechProject.model.User;
import com.webtech.webtechProject.repository.ClientFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientFormServices {

    @Autowired
    private ClientFormRepository clientFormRepository;

    @Autowired
    private CustomUserDetailsService  userService;



}
