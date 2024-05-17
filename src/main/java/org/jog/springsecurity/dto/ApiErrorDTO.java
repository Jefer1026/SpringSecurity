package org.jog.springsecurity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class ApiErrorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7819554752159060114L;

    private String backendMessage;
    private String message;
    private String URL;
    private String method;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime timestamp;

}
