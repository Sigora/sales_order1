package com.sales.dto;

/**
 * Created by starnakin on 09.04.2016.
 */
public class CodeDescriptionDto {
    private String code;
    private String description;

    public CodeDescriptionDto(String code, String description){
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
