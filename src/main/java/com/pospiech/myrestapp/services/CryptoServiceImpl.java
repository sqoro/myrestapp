package com.pospiech.myrestapp.services;

import com.pospiech.myrestapp.repositories.CryptoRepository;
import com.pospiech.myrestapp.api.mapper.CryptoMapper;
import com.pospiech.myrestapp.api.model.CryptoDTO;
import com.pospiech.myrestapp.domain.Crypto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class CryptoServiceImpl implements CryptoService {

    CryptoRepository cryptoRepository;
    CryptoMapper cryptoMapper;

    public CryptoServiceImpl(CryptoRepository cryptoRepository, CryptoMapper cryptoMapper) {
        this.cryptoRepository = cryptoRepository;
        this.cryptoMapper = cryptoMapper;
    }

    @Override
    public CryptoDTO getCryptoById(Long id) {
        return cryptoMapper.cryptoToCryptoDTO(cryptoRepository.findById(id).get());
    }

    @Override
    public List<CryptoDTO> getCryptoByName(String name) {
        return cryptoRepository.getCryptoByName(name)
                .stream()
                .map(cryptoMapper::cryptoToCryptoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CryptoDTO> getCryptoByPrice(String price) {
        return cryptoRepository.getCryptoByPrice(price)
                .stream()
                .map(cryptoMapper::cryptoToCryptoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CryptoDTO createNewCrypto(CryptoDTO cryptoDTO) {
        Crypto crypto = cryptoMapper.cryptoDTOToCrypto(cryptoDTO);
        Crypto savedCrypto = cryptoRepository.save(crypto);

        return cryptoMapper.cryptoToCryptoDTO(savedCrypto);
    }

    @Override
    public CryptoDTO updateCrypto(Long id, CryptoDTO cryptoDTO) {
        Crypto crypto = cryptoMapper.cryptoDTOToCrypto(cryptoDTO);
        crypto.setId(id);

        Crypto savedCrypto = cryptoRepository.save(crypto);

        return cryptoMapper.cryptoToCryptoDTO(savedCrypto);
    }

    @Override
    @Transactional
    public void deleteCryptoById(Long id) {
        cryptoRepository.deleteCryptoById(id);
    }
}
