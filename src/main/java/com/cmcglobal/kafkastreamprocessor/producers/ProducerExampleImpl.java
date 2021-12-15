package com.cmcglobal.kafkastreamprocessor.producers;

import com.cmcglobal.avro.ExampleAvro;
import com.cmcglobal.kafkastreamprocessor.configs.TopicConfig;
import com.cmcglobal.kafkastreamprocessor.entities.Example;
import com.cmcglobal.kafkastreamprocessor.mappers.EntityMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ProducerExampleImpl implements BaseProducerInterface {

    @Autowired
    protected KafkaTemplate<String, ExampleAvro> kafkaTemplate;
    @Autowired
    protected EntityMapper entityMapper;

    @Override
    public void producer() {
        Example example = Example
                .builder()
                .id(10)
                .age(10)
                .name("Nguyễn Khánh")
                .build();
        ExampleAvro exampleAvro = entityMapper.exampleToAvro(example);
        kafkaTemplate.send(TopicConfig.DOMAIN_EVENT_TOPIC, exampleAvro);
    }
}
