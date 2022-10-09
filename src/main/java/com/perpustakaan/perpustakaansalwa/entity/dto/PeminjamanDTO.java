package com.perpustakaan.perpustakaansalwa.entity.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class PeminjamanDTO {
    private Long id;

    private Date tglPeminjaman;

    private Date tglKembali;

}

