package pl.hetman.wiktoria.spring.learn.app.shelter.web.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.hetman.wiktoria.spring.learn.app.shelter.repository.entity.CatEntity;
import pl.hetman.wiktoria.spring.learn.app.shelter.web.model.CatModel;

@Component
public class CatMapper {
    ModelMapper modelMapper = new ModelMapper();

    public CatEntity from(CatModel catModel){

        CatEntity mappedCatEntity = modelMapper.map(catModel, CatEntity.class);

        return mappedCatEntity;
    }
}
