package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Peminjaman;
import com.perpustakaan.perpustakaansalwa.entity.dto.PeminjamanDTO;
import com.perpustakaan.perpustakaansalwa.entity.mapping.PeminjamanMapping;
import com.perpustakaan.perpustakaansalwa.repository.PeminjamanRepository;
import com.perpustakaan.perpustakaansalwa.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    private PeminjamanRepository repository;

    @Override
    public PeminjamanDTO save(PeminjamanDTO param){
        Peminjaman data = repository.save(PeminjamanMapping.instance.toEntity(param));
        return PeminjamanMapping.instance.toDto(data);
    }

    @Override
    public List<PeminjamanDTO> findAllData()
    {
        return  PeminjamanMapping.instance.toListDto(repository.findAll());

    }
    @Override
    public PeminjamanDTO update(PeminjamanDTO param, Long id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null){
            data.setTglPeminjaman(param.getTglPeminjaman()== null ? data.getTglPeminjaman() : param.getTglPeminjaman());
            data.setTglKembali(param.getTglKembali()== null ? data.getTglKembali() : param.getTglKembali());

            return  PeminjamanMapping.instance.toDto(data);
        }
        return PeminjamanMapping.instance.toDto(data);

    }
    @Override
    public Boolean delete(Long id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PeminjamanDTO findById(Long id) {
        return PeminjamanMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}