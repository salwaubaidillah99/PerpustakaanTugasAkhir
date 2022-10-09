package com.perpustakaan.perpustakaansalwa.service;

import com.perpustakaan.perpustakaansalwa.entity.Penerbit;
import java.util.List;

public interface PenerbitService {
    Penerbit save(Penerbit param);

    List<Penerbit> findAllData();

    Penerbit update(Penerbit param, Long id);

    Boolean delete(Long id);

    Penerbit findById(Long id);
}
