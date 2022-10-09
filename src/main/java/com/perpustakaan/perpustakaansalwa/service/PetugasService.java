package com.perpustakaan.perpustakaansalwa.service;

import com.perpustakaan.perpustakaansalwa.entity.Petugas;
import java.util.List;

public interface PetugasService {
    Petugas save(Petugas param);

    List<Petugas> findAllData();

    Petugas update(Petugas param, Long id);

    Boolean delete(Long id);

    Petugas findById(Long id);
}
