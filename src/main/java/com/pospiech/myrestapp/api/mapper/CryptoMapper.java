package com.pospiech.myrestapp.api.mapper;

import com.pospiech.myrestapp.domain.Crypto;
import com.pospiech.myrestapp.api.model.CryptoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CryptoMapper {

    CryptoMapper INSTANCE = Mappers.getMapper(CryptoMapper.class);

    CryptoDTO cryptoToCryptoDTO(Crypto crypto);

    Crypto cryptoDTOToCrypto(CryptoDTO cryptoDTO);
}
