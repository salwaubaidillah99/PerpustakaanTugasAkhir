package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Anggota;
import com.perpustakaan.perpustakaansalwa.entity.dto.AnggotaDTO;
import com.perpustakaan.perpustakaansalwa.entity.mapping.AnggotaMapping;
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
    public AnggotaDTO save(AnggotaDTO param){
        Anggota data = repository.save(AnggotaMapping.instance.toEntity(param));
        return AnggotaMapping.instance.toDto(data);
    }

    @Override
    public List<AnggotaDTO> findAllData()
    {
        return  AnggotaMapping.instance.toListDto(repository.findAll());

    }
    @Override
    public AnggotaDTO update(AnggotaDTO param, Long id) {
        Anggota data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNamaAnggota(param.getNamaAnggota()== null ? data.getNamaAnggota() : param.getNamaAnggota());
            data.setJenisKelamin(param.getJenisKelamin()== null ? data.getJenisKelamin() : param.getJenisKelamin());
            data.setAlamat(param.getAlamat()== null ? data.getAlamat() : param.getAlamat());
            data.setNoTelp(param.getNoTelp()== null ? data.getNoTelp() : param.getNoTelp());


            return  AnggotaMapping.instance.toDto(data);
        }
        return AnggotaMapping.instance.toDto(data);

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
    public AnggotaDTO findById(Long id) {
        return AnggotaMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}

