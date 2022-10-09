package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Pengarang;
import com.perpustakaan.perpustakaansalwa.entity.dto.PengarangDTO;
import com.perpustakaan.perpustakaansalwa.entity.mapping.PengarangMapping;
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
    public PengarangDTO save(PengarangDTO param){
        Pengarang data = repository.save(PengarangMapping.instance.toEntity(param));
        return PengarangMapping.instance.toDto(data);
    }

    @Override
    public List<PengarangDTO> findAllData()
    {
        return  PengarangMapping.instance.toListDto(repository.findAll());

    }
    @Override
    public PengarangDTO update(PengarangDTO param, Long id) {
        Pengarang data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNamaPengarang(param.getNamaPengarang()== null ? data.getNamaPengarang() : param.getNamaPengarang());
            data.setAlamat(param.getAlamat()== null ? data.getAlamat() : param.getAlamat());
            data.setNoTelp(param.getNoTelp()== null ? data.getNoTelp() : param.getNoTelp());

            return  PengarangMapping.instance.toDto(data);
        }
        return PengarangMapping.instance.toDto(data);

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
    public PengarangDTO findById(Long id) {
        return PengarangMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}