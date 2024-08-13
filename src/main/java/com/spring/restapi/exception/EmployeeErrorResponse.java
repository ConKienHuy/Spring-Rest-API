package com.spring.restapi.exception;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeErrorResponse {
    // The custom java clas to sent back to client as JSON
    private int status;
    private String message;
    private long time;

    // Contructors

    // Getter, Setter
}
