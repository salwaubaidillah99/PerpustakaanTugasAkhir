package com.perpustakaan.perpustakaansalwa.service;

import com.perpustakaan.perpustakaansalwa.entity.Anggota;
import java.util.List;

public interface AnggotaService {
    Anggota save(Anggota param);

    List<Anggota> findAllData();

    Anggota update(Anggota param, Long id);

    Boolean delete(Long id);

    Anggota findById(Long id);
}
