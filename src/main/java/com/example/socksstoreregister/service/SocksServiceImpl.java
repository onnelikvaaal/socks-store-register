package com.example.socksstoreregister.service;

import com.example.socksstoreregister.dto.SocksDTO;
import com.example.socksstoreregister.entity.SocksEntity;
import com.example.socksstoreregister.exceptions.SocksNotFoundException;
import com.example.socksstoreregister.repository.SocksRepository;
import com.example.socksstoreregister.util.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocksServiceImpl implements SocksService {

    private final SocksRepository socksRepository;

    @Override
    public void incomeSocks(SocksDTO socksDTO) {
        SocksEntity socksEntity = socksRepository.findFirstByColorAndCottonPart(socksDTO.getColor(), socksDTO.getCottonPart());
        if (socksEntity == null) {
            socksEntity = new SocksEntity();
            socksEntity.setColor(socksDTO.getColor());
            socksEntity.setCottonPart(socksDTO.getCottonPart());
            socksEntity.setQuantity(socksDTO.getQuantity());
        } else {
            socksEntity.setQuantity(socksEntity.getQuantity() + socksDTO.getQuantity());
        }
        socksRepository.save(socksEntity);
    }

    @Override
    public void outcomeSocks(SocksDTO socksDTO) {
        SocksEntity socksEntity = socksRepository.findFirstByColorAndCottonPart(socksDTO.getColor(), socksDTO.getCottonPart());
        if (socksEntity != null) {
            socksEntity.setQuantity(socksEntity.getQuantity() - socksDTO.getQuantity());
            socksRepository.save(socksEntity);
        } else {
            throw new SocksNotFoundException("Такие носки не найдены! Проверьте цвет и/или содержание хлопка");
        }
    }

    @Override
    public Integer getSocksByOperation(String color, Operation operation, Integer cottonPart) {
        Integer result = 0;
        switch (operation) {
            case moreThan:
                result = socksRepository.getSocksEntityByColorAndCottonPartMoreThan(color, cottonPart);
                break;
            case lessThan:
                result = socksRepository.getSocksEntityByColorAndCottonPartLessThan(color, cottonPart);
                break;
            case equal:
                result = socksRepository.getSocksEntityByColorAndCottonPartEqualTo(color, cottonPart);
                break;
        }
        return result;
    }
}
