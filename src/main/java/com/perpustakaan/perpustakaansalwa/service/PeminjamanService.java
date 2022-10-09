package com.perpustakaan.perpustakaansalwa.service;

import com.perpustakaan.perpustakaansalwa.entity.Peminjaman;
import java.util.List;

public interface PeminjamanService {
    Peminjaman save(Peminjaman param);

    List<Peminjaman> findAllData();

    Peminjaman update(Peminjaman param, Long id);

    Boolean delete(Long id);

    Peminjaman findById(Long id);
}
