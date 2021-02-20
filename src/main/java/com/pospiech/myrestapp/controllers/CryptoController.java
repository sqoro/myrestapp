package com.pospiech.myrestapp.controllers;

import com.pospiech.myrestapp.api.model.CryptoDTO;
import com.pospiech.myrestapp.api.model.CryptoListDTO;
import com.pospiech.myrestapp.services.CryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/api/crypto/")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CryptoDTO> getCryptoById(@PathVariable Long id) {
        return new ResponseEntity<CryptoDTO>(cryptoService.getCryptoById(id), HttpStatus.OK);
    }

    @GetMapping("findByName/{name}")
    public ResponseEntity<CryptoListDTO> getCryptoByName(@PathVariable String name) {
        return new ResponseEntity<CryptoListDTO>(
                new CryptoListDTO(cryptoService.getCryptoByName(name)), HttpStatus.OK
        );
    }

    @GetMapping("findByPrice/{price}")
    public ResponseEntity<CryptoListDTO> getCryptoByPrice(@PathVariable String price) {
        return new ResponseEntity<CryptoListDTO>(
                new CryptoListDTO(cryptoService.getCryptoByPrice(price)), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<CryptoDTO> createNewCrypto(@RequestBody CryptoDTO cryptoDTO) {
        return new ResponseEntity<CryptoDTO>(cryptoService.createNewCrypto(cryptoDTO), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CryptoDTO> updateCrypto(@PathVariable Long id, @RequestBody CryptoDTO cryptoDTO) {
        return new ResponseEntity<CryptoDTO>(cryptoService.updateCrypto(id, cryptoDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCryptoById(@PathVariable Long id) {
        cryptoService.deleteCryptoById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
