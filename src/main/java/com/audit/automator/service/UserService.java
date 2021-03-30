package com.audit.automator.service;

import com.audit.automator.entities.DataRepository;
import com.audit.automator.entities.User;
import com.audit.automator.pojo.UserCreationRequest;
import com.audit.automator.utils.ProxyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final DataRepository dataRepository;
    final ProxyUtil proxyUtil;

    @Autowired
    public UserService(DataRepository dataRepository, ProxyUtil proxyUtil) {
        this.dataRepository = dataRepository;
        this.proxyUtil = proxyUtil;
    }

    public void createUser(UserCreationRequest request) {
        System.out.println(request);
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setEmailAddress(request.getEmail());

        proxyUtil.executeWithNewTransaction(() -> {
            dataRepository.create(user);
        });
    }

}

