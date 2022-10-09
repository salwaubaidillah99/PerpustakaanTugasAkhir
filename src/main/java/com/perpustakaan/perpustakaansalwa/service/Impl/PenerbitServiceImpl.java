package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Penerbit;
import com.perpustakaan.perpustakaansalwa.entity.dto.PenerbitDTO;
import com.perpustakaan.perpustakaansalwa.entity.mapping.PenerbitMapping;
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
    public PenerbitDTO save(PenerbitDTO param){
        Penerbit data = repository.save(PenerbitMapping.instance.toEntity(param));
        return PenerbitMapping.instance.toDto(data);
    }

    @Override
    public List<PenerbitDTO> findAllData()
    {
        return  PenerbitMapping.instance.toListDto(repository.findAll());

    }
    @Override
    public PenerbitDTO update(PenerbitDTO param, Long id) {
        Penerbit data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNamaPenerbit(param.getNamaPenerbit()== null ? data.getNamaPenerbit() : param.getNamaPenerbit());
            data.setAlamat(param.getAlamat()== null ? data.getAlamat() : param.getAlamat());
            data.setNoTelp(param.getNoTelp()== null ? data.getNoTelp() : param.getNoTelp());

            return  PenerbitMapping.instance.toDto(data);
        }
        return PenerbitMapping.instance.toDto(data);

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
    public PenerbitDTO findById(Long id) {
        return PenerbitMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}