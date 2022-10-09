package com.perpustakaan.perpustakaansalwa.repository;

import com.perpustakaan.perpustakaansalwa.entity.Pengarang;
import com.perpustakaan.perpustakaansalwa.entity.Petugas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PengarangRepository extends JpaRepository<Pengarang, Long> {

}
