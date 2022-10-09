package com.perpustakaan.perpustakaansalwa.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "peminjaman")
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(11)")
    private Long id;

    @Column(columnDefinition = "DATE")
    private Date tglPeminjaman;

    @Column(columnDefinition = "DATE")
    private Date tglKembali;


}
