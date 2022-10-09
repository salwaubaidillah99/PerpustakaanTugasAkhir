package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Buku;
import com.perpustakaan.perpustakaansalwa.repository.BukuRepository;
import com.perpustakaan.perpustakaansalwa.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuServiceImpl implements BukuService {

    @Autowired
    private BukuRepository repository;

    @Override
    public Buku save(Buku param)
    {
        return repository.save(param);
    }

    @Override
    public List<Buku> findAllData()
    {
        return  repository.findAll();

    }
    @Override
    public Buku update(Buku param, Long id) {
        Buku data = repository.findById(id).orElse(null);

        if (data != null){
            data.setJudulBuku(param.getJudulBuku()== null ? data.getJudulBuku() : param.getJudulBuku());
            data.setTahunTerbit(param.getTahunTerbit()== null ? data.getTahunTerbit() : param.getTahunTerbit());
            data.setJumlah(param.getJumlah()== null ? data.getJumlah() : param.getJumlah());
            data.setIsbn(param.getIsbn()== null ? data.getIsbn() : param.getIsbn());



            return  repository.save(data);
        }
        return data;

    }
    @Override
    public Boolean delete(Long id) {
        Buku data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public Buku findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

