package com.example.fipetable.model;

import com.example.fipetable.dto.DataDTO;

public class Data {
    String code;
    String name;

    public Data(DataDTO dataDTO){
        this.code = dataDTO.code();
        this.name = dataDTO.name();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                """
                Código: %s Descrição: %s
                """, code, name
        );
    }
}
