package com.perpustakaan.perpustakaansalwa.entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class PenerbitDTO {
    private Long id;

    private String namaPenerbit;

    private String alamat;

    private String noTelp;

}

