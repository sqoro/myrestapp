package com.pospiech.myrestapp.bootstrap;

import com.pospiech.myrestapp.repositories.CountryRepository;
import com.pospiech.myrestapp.repositories.CryptoRepository;
import com.pospiech.myrestapp.domain.Country;
import com.pospiech.myrestapp.domain.Crypto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataLoader implements CommandLineRunner {

    CountryRepository countryRepository;
    CryptoRepository cryptoRepository;

    public DBDataLoader(CountryRepository countryRepository, CryptoRepository cryptoRepository) {
        this.countryRepository = countryRepository;
        this.cryptoRepository = cryptoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Country germany = new Country();
        germany.setId(1L);
        germany.setName("Germany");
        germany.setCountryCode("DE");
        Country poland = new Country();
        poland.setId(2L);
        poland.setName("Poland");
        poland.setCountryCode("PL");
        Country japan = new Country();
        japan.setId(3L);
        japan.setName("Japan");
        japan.setCountryCode("JP");
        Country china = new Country();
        china.setId(4L);
        china.setName("China");
        china.setCountryCode("CN");
        Country russia = new Country();
        russia.setId(5L);
        russia.setName("Russia");
        russia.setCountryCode("RU");
        Crypto bitcoin = new Crypto();
        bitcoin.setId(1L);
        bitcoin.setName("Bitcoin");
        bitcoin.setPrice("$48958.10");
        Crypto ethereum = new Crypto();
        ethereum.setId(2L);
        ethereum.setName("Ethereum");
        ethereum.setPrice("$1821.79");
        Crypto polkadot = new Crypto();
        polkadot.setId(3L);
        polkadot.setName("polkadot");
        polkadot.setPrice("$81.44");




        countryRepository.save(germany);
        countryRepository.save(poland);
        countryRepository.save(japan);
        countryRepository.save(china);
        countryRepository.save(russia);
        cryptoRepository.save(bitcoin);
        cryptoRepository.save(ethereum);
        cryptoRepository.save(polkadot);
        System.out.println("Data loaded to DB!");
    }
}
