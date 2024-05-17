package org.jog.springsecurity.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jog.springsecurity.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;


@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        ApiErrorDTO apiErrorDTO = new ApiErrorDTO();
        apiErrorDTO.setMessage("Access denied, please try again");
        apiErrorDTO.setBackendMessage(accessDeniedException.getLocalizedMessage());
        apiErrorDTO.setMethod(request.getMethod());
        apiErrorDTO.setURL(request.getRequestURL().toString());
        apiErrorDTO.setTimestamp(LocalDateTime.now());


        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(), apiErrorDTO);

        String mapperAsJson = mapper.writeValueAsString(apiErrorDTO);
        response.getWriter().write(mapperAsJson);
    }
}
