package com.kiranpariyar.drones.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private String error;


    @Builder
    public ApiResponse(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponseBuilder<T> success() {
        return ApiResponse.<T>builder()
                .success(true);
    }


    public static ApiResponseBuilder<String> error(String error) {
        return ApiResponse.<String>builder()
                .success(false)
                .error(error);
    }


    public static ApiResponseBuilder<String> clientError(String error) {
        return ApiResponse.<String>builder()
                .success(false)
                .error(error);
    }


    public static ApiResponseBuilder<String> serverError(String error) {
        return ApiResponse.<String>builder()
                .success(false)
                .error(error);
    }

}




