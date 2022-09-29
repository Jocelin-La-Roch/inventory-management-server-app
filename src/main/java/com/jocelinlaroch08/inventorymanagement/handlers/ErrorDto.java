package com.jocelinlaroch08.inventorymanagement.handlers;


import com.jocelinlaroch08.inventorymanagement.exception.ErrorCode;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

    private Integer httpCode;

    private ErrorCode errorCode;

    private String message;

    private List<String> errors = new ArrayList<>();

}
