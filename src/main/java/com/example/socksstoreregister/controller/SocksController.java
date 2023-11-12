package com.example.socksstoreregister.controller;

import com.example.socksstoreregister.dto.SocksDTO;
import com.example.socksstoreregister.service.SocksService;
import com.example.socksstoreregister.util.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/socks")
public class SocksController {

    private final SocksService socksService;

    @PostMapping("/income")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Error occurred")
    })
    public ResponseEntity<Void> incomeSocks(@RequestBody SocksDTO socksDTO) {
        socksService.incomeSocks(socksDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/outcome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Error occurred")
    })
    public ResponseEntity<Void> outcomeSocks(@RequestBody SocksDTO socksDTO) {
        socksService.outcomeSocks(socksDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Integer.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Error occurred")
    })
    public ResponseEntity<Integer> getSocksByOperation(@RequestParam String color,
                                                       @RequestParam Operation operation,
                                                       @RequestParam Integer cottonPart) {
        Integer result = socksService.getSocksByOperation(color, operation, cottonPart);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
