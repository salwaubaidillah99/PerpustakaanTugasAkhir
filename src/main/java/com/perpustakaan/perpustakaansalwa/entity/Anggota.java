package com.perpustakaan.perpustakaansalwa.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "anggota")
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(11)")
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String namaAnggota;

    @Column(columnDefinition = "VARCHAR(255)")
    private String jenisKelamin;

    @Column(columnDefinition = "VARCHAR(255)")
    private String alamat;

    @Column(columnDefinition = "VARCHAR(20)")
    private String noTelp;
}
