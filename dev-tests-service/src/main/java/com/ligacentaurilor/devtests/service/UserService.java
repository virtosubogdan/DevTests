package com.ligacentaurilor.devtests.service;


import com.ligacentaurilor.devtests.service.transport.UserTO;

import java.util.List;

public interface UserService {

    public List<UserTO> getAllUsers();
}
