package com.perpustakaan.perpustakaansalwa.entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class PengembalianDTO {
    private Long id;

    private Date tglPengembalian;

    private Double denda;


}

