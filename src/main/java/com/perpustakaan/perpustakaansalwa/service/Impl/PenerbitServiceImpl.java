package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Penerbit;
import com.perpustakaan.perpustakaansalwa.repository.PenerbitRepository;
import com.perpustakaan.perpustakaansalwa.service.PenerbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenerbitServiceImpl implements PenerbitService {

    @Autowired
    private PenerbitRepository repository;

    @Override
    public Penerbit save(Penerbit param)
    {
        return repository.save(param);
    }

    @Override
    public List<Penerbit> findAllData()
    {
        return  repository.findAll();

    }
    @Override
    public Penerbit update(Penerbit param, Long id) {
        Penerbit data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNamaPenerbit(param.getNamaPenerbit()== null ? data.getNamaPenerbit() : param.getNamaPenerbit());
            data.setAlamat(param.getAlamat()== null ? data.getAlamat() : param.getAlamat());
            data.setNoTelp(param.getNoTelp()== null ? data.getNoTelp() : param.getNoTelp());

            return  repository.save(data);
        }
        return data;

    }
    @Override
    public Boolean delete(Long id) {
        Penerbit data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public Penerbit findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

