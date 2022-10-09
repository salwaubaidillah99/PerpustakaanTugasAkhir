package com.perpustakaan.perpustakaansalwa.service;

import com.perpustakaan.perpustakaansalwa.entity.Buku;
import java.util.List;

public interface BukuService {
    Buku save(Buku param);

    List<Buku> findAllData();

    Buku update(Buku param, Long id);

    Boolean delete(Long id);

    Buku findById(Long id);
}
