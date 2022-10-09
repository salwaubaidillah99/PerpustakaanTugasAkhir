package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Pengarang;
import com.perpustakaan.perpustakaansalwa.repository.PengarangRepository;
import com.perpustakaan.perpustakaansalwa.service.PengarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengarangServiceImpl implements PengarangService {

    @Autowired
    private PengarangRepository repository;

    @Override
    public Pengarang save(Pengarang param)
    {
        return repository.save(param);
    }

    @Override
    public List<Pengarang> findAllData()
    {
        return  repository.findAll();

    }
    @Override
    public Pengarang update(Pengarang param, Long id) {
        Pengarang data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNamaPengarang(param.getNamaPengarang()== null ? data.getNamaPengarang() : param.getNamaPengarang());
            data.setAlamat(param.getAlamat()== null ? data.getAlamat() : param.getAlamat());
            data.setNoTelp(param.getNoTelp()== null ? data.getNoTelp() : param.getNoTelp());

            return  repository.save(data);
        }
        return data;

    }
    @Override
    public Boolean delete(Long id) {
        Pengarang data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public Pengarang findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

