package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Petugas;
import com.perpustakaan.perpustakaansalwa.repository.PetugasRepository;
import com.perpustakaan.perpustakaansalwa.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetugasServiceImpl implements PetugasService {

    @Autowired
    private PetugasRepository repository;

    @Override
    public Petugas save(Petugas param)
    {
        return repository.save(param);
    }

    @Override
    public List<Petugas> findAllData()
    {
        return  repository.findAll();

    }
    @Override
    public Petugas update(Petugas param, Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNamaPetugas(param.getNamaPetugas()== null ? data.getNamaPetugas() : param.getNamaPetugas());
            data.setAlamat(param.getAlamat()== null ? data.getAlamat() : param.getAlamat());
            data.setNoTelp(param.getNoTelp()== null ? data.getNoTelp() : param.getNoTelp());



            return  repository.save(data);
        }
        return data;

    }
    @Override
    public Boolean delete(Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public Petugas findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

