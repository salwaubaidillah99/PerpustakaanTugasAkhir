package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Peminjaman;
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
    public Peminjaman save(Peminjaman param)
    {
        return repository.save(param);
    }

    @Override
    public List<Peminjaman> findAllData()
    {
        return  repository.findAll();

    }
    @Override
    public Peminjaman update(Peminjaman param, Long id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null){
            data.setTglPeminjaman(param.getTglPeminjaman()== null ? data.getTglPeminjaman() : param.getTglPeminjaman());
            data.setTglKembali(param.getTglKembali()== null ? data.getTglKembali() : param.getTglKembali());



            return  repository.save(data);
        }
        return data;

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
    public Peminjaman findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

