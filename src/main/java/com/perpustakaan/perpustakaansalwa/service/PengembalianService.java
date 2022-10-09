package com.perpustakaan.perpustakaansalwa.service;

import com.perpustakaan.perpustakaansalwa.entity.Pengembalian;
import java.util.List;

public interface PengembalianService {
    Pengembalian save(Pengembalian param);

    List<Pengembalian> findAllData();

    Pengembalian update(Pengembalian param, Long id);

    Boolean delete(Long id);

    Pengembalian findById(Long id);
}
