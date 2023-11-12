package com.example.socksstoreregister.repository;

import com.example.socksstoreregister.entity.SocksEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SocksRepository extends CrudRepository<SocksEntity, Integer> {

    SocksEntity findFirstByColorAndCottonPart(String color, Integer cottonPart);

    @Query(value = "SELECT sum(quantity) FROM socks WHERE color = :color AND cotton_part > :cottonPart GROUP BY color",
            nativeQuery = true)
    Integer getSocksEntityByColorAndCottonPartMoreThan(@Param("color") String color,
                                                             @Param("cottonPart") Integer cottonPart);

    @Query(value = "SELECT sum(quantity) FROM socks WHERE color = :color AND cotton_part < :cottonPart GROUP BY color",
            nativeQuery = true)
    Integer getSocksEntityByColorAndCottonPartLessThan(@Param("color") String color,
                                                             @Param("cottonPart") Integer cottonPart);

    @Query(value = "SELECT sum(quantity) FROM socks WHERE color = :color AND cotton_part = :cottonPart GROUP BY color",
            nativeQuery = true)
    Integer getSocksEntityByColorAndCottonPartEqualTo(@Param("color") String color,
                                                            @Param("cottonPart") Integer cottonPart);

}

