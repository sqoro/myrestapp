package com.pospiech.myrestapp.services;

import com.pospiech.myrestapp.api.model.CryptoDTO;

import java.util.List;

public interface CryptoService {

    CryptoDTO getCryptoById(Long id);

    List<CryptoDTO> getCryptoByName(String name);

    List<CryptoDTO> getCryptoByPrice(String price);

    CryptoDTO createNewCrypto(CryptoDTO cryptoDTO);

    CryptoDTO updateCrypto(Long id, CryptoDTO cryptoDTO);

    void deleteCryptoById(Long id);
}
