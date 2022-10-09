package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Pengarang;
import com.perpustakaan.perpustakaansalwa.entity.Petugas;
import com.perpustakaan.perpustakaansalwa.entity.dto.PengarangDTO;
import com.perpustakaan.perpustakaansalwa.entity.dto.PetugasDTO;
import com.perpustakaan.perpustakaansalwa.entity.mapping.PengarangMapping;
import com.perpustakaan.perpustakaansalwa.entity.mapping.PetugasMapping;
import com.perpustakaan.perpustakaansalwa.repository.PengarangRepository;
import com.perpustakaan.perpustakaansalwa.repository.PetugasRepository;
import com.perpustakaan.perpustakaansalwa.service.PengarangService;
import com.perpustakaan.perpustakaansalwa.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetugasServiceImpl implements PetugasService {

    @Autowired
    private PetugasRepository repository;

    @Override
    public PetugasDTO save(PetugasDTO param) {
        Petugas data = repository.save(PetugasMapping.instance.toEntity(param));
        return PetugasMapping.instance.toDto(data);
    }

    @Override
    public List<PetugasDTO> findAllData() {
        return PetugasMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public PetugasDTO update(PetugasDTO param, Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNamaPetugas(param.getNamaPetugas() == null ? data.getNamaPetugas() : param.getNamaPetugas());
            data.setAlamat(param.getAlamat() == null ? data.getAlamat() : param.getAlamat());
            data.setNoTelp(param.getNoTelp() == null ? data.getNoTelp() : param.getNoTelp());

            return PetugasMapping.instance.toDto(data);
        }
        return PetugasMapping.instance.toDto(data);

    }

    @Override
    public Boolean delete(Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null) {
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PetugasDTO findById(Long id) {
        return PetugasMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}