package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Buku;
import com.perpustakaan.perpustakaansalwa.entity.dto.BukuDTO;
import com.perpustakaan.perpustakaansalwa.entity.mapping.BukuMapping;
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
    public BukuDTO save(BukuDTO param){
        Buku data = repository.save(BukuMapping.instance.toEntity(param));
        return BukuMapping.instance.toDto(data);
    }

    @Override
    public List<BukuDTO> findAllData()
    {
        return  BukuMapping.instance.toListDto(repository.findAll());

    }
    @Override
    public BukuDTO update(BukuDTO param, Long id) {
        Buku data = repository.findById(id).orElse(null);

        if (data != null){
            data.setJudulBuku(param.getJudulBuku()== null ? data.getJudulBuku() : param.getJudulBuku());
            data.setTahunTerbit(param.getTahunTerbit()== null ? data.getTahunTerbit() : param.getTahunTerbit());
            data.setJumlah(param.getJumlah()== null ? data.getJumlah() : param.getJumlah());
            data.setIsbn(param.getIsbn()== null ? data.getIsbn() : param.getIsbn());


            return  BukuMapping.instance.toDto(data);
        }
        return BukuMapping.instance.toDto(data);

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
    public BukuDTO findById(Long id) {
        return BukuMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}