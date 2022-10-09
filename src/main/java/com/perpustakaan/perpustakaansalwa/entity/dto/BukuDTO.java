package com.perpustakaan.perpustakaansalwa.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BukuDTO {
    private Long id;

    private String judulBuku;

    private String tahunTerbit;

    private String jumlah;

    private String isbn;
}
