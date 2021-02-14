package com.pospiech.myrestapp.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CryptoListDTO {
    private List<CryptoDTO> cryptoList;
}
