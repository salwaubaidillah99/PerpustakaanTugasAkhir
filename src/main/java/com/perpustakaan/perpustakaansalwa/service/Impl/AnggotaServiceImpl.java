package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Anggota;
import com.perpustakaan.perpustakaansalwa.repository.AnggotaRepository;
import com.perpustakaan.perpustakaansalwa.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaServiceImpl implements AnggotaService {

    @Autowired
    private AnggotaRepository repository;

    @Override
    public Anggota save(Anggota param)
    {
        return repository.save(param);
    }

    @Override
    public List<Anggota> findAllData()
    {
        return  repository.findAll();

    }
    @Override
    public Anggota update(Anggota param, Long id) {
        Anggota data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNamaAnggota(param.getNamaAnggota()== null ? data.getNamaAnggota() : param.getNamaAnggota());
            data.setJenisKelamin(param.getJenisKelamin()== null ? data.getJenisKelamin() : param.getJenisKelamin());
            data.setAlamat(param.getAlamat()== null ? data.getAlamat() : param.getAlamat());
            data.setNoTelp(param.getNoTelp()== null ? data.getNoTelp() : param.getNoTelp());



            return  repository.save(data);
        }
        return data;

    }
    @Override
    public Boolean delete(Long id) {
        Anggota data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public Anggota findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

