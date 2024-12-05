package com.faketrello.trelloback.utils;

import com.faketrello.trelloback.entity.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<ApiResponse> buildResponse(int result, String successMessage, String failureMessage) {
        if (result > 0) {
            return ResponseEntity.ok(new ApiResponse(true, successMessage));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, failureMessage));
        }
    }
}
