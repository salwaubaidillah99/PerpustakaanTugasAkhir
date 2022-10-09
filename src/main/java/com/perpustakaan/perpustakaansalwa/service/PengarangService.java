package com.perpustakaan.perpustakaansalwa.service;

import com.perpustakaan.perpustakaansalwa.entity.Pengarang;
import java.util.List;

public interface PengarangService {
    Pengarang save(Pengarang param);

    List<Pengarang> findAllData();

    Pengarang update(Pengarang param, Long id);

    Boolean delete(Long id);

    Pengarang findById(Long id);
}
