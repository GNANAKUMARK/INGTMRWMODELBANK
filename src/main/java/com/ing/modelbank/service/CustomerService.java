package com.ing.modelbank.service;

import com.ing.modelbank.pojo.LoginRequest;
import com.ing.modelbank.pojo.LoginResponse;

public interface CustomerService {

	LoginResponse findByCustomerIdAndPassword(LoginRequest loginRequest);

}
