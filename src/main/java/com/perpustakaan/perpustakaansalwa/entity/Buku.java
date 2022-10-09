package com.perpustakaan.perpustakaansalwa.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "buku")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(11)")
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String judulBuku;

    @Column(columnDefinition = "VARCHAR(255)")
    private String tahunTerbit;

    @Column(columnDefinition = "INTEGER")
    private String jumlah;

    @Column(columnDefinition = "VARCHAR(255)")
    private String isbn;
}
