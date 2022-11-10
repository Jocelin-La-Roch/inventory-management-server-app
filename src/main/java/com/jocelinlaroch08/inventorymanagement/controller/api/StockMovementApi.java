package com.jocelinlaroch08.inventorymanagement.controller.api;

import com.jocelinlaroch08.inventorymanagement.dto.StockMovementDto;
import com.jocelinlaroch08.inventorymanagement.utils.Utils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface StockMovementApi {

    @PostMapping(value = Utils.APP_ROOT + "/stock-movements/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    StockMovementDto save(@RequestBody StockMovementDto stockMovementDto);

    @GetMapping(value = Utils.APP_ROOT+"/stock-movements/{stockMovementId}", produces = MediaType.APPLICATION_JSON_VALUE)
    StockMovementDto findById(@PathVariable("stockMovementId") Integer id);

    @GetMapping(value = Utils.APP_ROOT+"/stock-movements/{stockMovementCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    StockMovementDto findByCode(@PathVariable("stockMovementCode") String code);

    @GetMapping(value = Utils.APP_ROOT+"/stock-movements/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<StockMovementDto> findAll();

    @DeleteMapping(value = Utils.APP_ROOT+"/stock-movements/delete/{stockMovementId}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("stockMovementId") Integer id);

}
