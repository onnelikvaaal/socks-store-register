package com.example.socksstoreregister.service;

import com.example.socksstoreregister.dto.SocksDTO;
import com.example.socksstoreregister.util.Operation;

public interface SocksService {

    void incomeSocks(SocksDTO socksDTO);

    void outcomeSocks(SocksDTO socksDTO);

    Integer getSocksByOperation(String color, Operation operation, Integer cottonPart);
}
