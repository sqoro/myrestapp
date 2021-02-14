package com.pospiech.myrestapp.repositories;

import com.pospiech.myrestapp.domain.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CryptoRepository extends JpaRepository<Crypto, Long> {
    List<Crypto> getCryptoByName(String crypto);

    List<Crypto> getCryptoByPrice(String price);

    void deleteCryptoById(Long id);
}
