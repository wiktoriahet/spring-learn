package pl.hetman.wiktoria.spring.learn.app.shelter.web.service.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.hetman.wiktoria.spring.learn.app.shelter.repository.entity.CatEntity;
import pl.hetman.wiktoria.spring.learn.app.shelter.web.model.CatModel;

@SpringBootTest
class CatMapperTest {

    @Autowired
    private CatMapper catMapper;

    @Test
    void from() {
        //given
        CatModel catModel = new CatModel();
        catModel.setName("Puszek");
        catModel.setTag(876);

        //when
        CatEntity mappedCatEntity = catMapper.from(catModel);

        //then
        Assertions.assertNotNull(mappedCatEntity, "mappedCatEntity is null");
        Assertions.assertNotNull(mappedCatEntity.getName(), "mappedCatEntity.getName() is null");

    }
}