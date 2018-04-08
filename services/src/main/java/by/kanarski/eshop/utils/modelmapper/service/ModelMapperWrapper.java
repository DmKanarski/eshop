package by.kanarski.eshop.utils.modelmapper.service;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Component
public class ModelMapperWrapper {
    
    private ModelMapper mainModelMapper;
    private ModelMapper emptyModelMapper;

    @Autowired
    public ModelMapperWrapper(List<Converter<?, ?>> converterList) {
        this.emptyModelMapper = new ModelMapper();
        emptyModelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        this.mainModelMapper = new ModelMapper();
        for (Converter<?, ?> converter : converterList) {
            this.mainModelMapper.addConverter(converter);
        }
    }

    public <D> D map(Object source, Class<D> destinationType) {
        return mainModelMapper.map(source, destinationType);
    }
    
    public <D> D map(Object source, Class<D> destinationType, String typeMapName) {
        return mainModelMapper.map(source, destinationType, typeMapName);
    }
    
    public void map(Object source, Object destination) {
        mainModelMapper.map(source, destination);
    }
    
    public void map(Object source, Object destination, String typeMapName) {
        mainModelMapper.map(source, destination, typeMapName);
    }
    
    public <D> D map(Object source, Type destinationType) {
        return mainModelMapper.map(source, destinationType);
    }
    
    public <D> D map(Object source, Type destinationType, String typeMapName) {
        return mainModelMapper.map(source, destinationType, typeMapName);
    }

    public <D> List<D> map(List<?> sourceList, Class<D> destinationType) {
        Assert.notNull(sourceList, "Cannot convert null list.");
        List<D> destinationList = new ArrayList<>();
        for (Object source : sourceList) {
            D destination = map(source, destinationType);
            destinationList.add(destination);
        }
        return destinationList;
    }

    public <D> Set<D> map(Set<?> sourceSet, Class<D> destinationType) {
        Assert.notNull(sourceSet, "Cannot convert null set.");
        Set<D> destinationSet = new HashSet<>();
        for (Object source : sourceSet) {
            D destination = map(source, destinationType);
            destinationSet.add(destination);
        }
        return destinationSet;
    }

    public <T> List<T> convertSetToList(Set<?> sourceSet, Class<T> destinationType) {
        Assert.notNull(sourceSet, "Cannot convert null set.");
        List<T> destinationList = new ArrayList<>();
        for (Object source : sourceSet) {
            T destination = map(source, destinationType);
            destinationList.add(destination);
        }
        return destinationList;
    }

    public <T> Set<T> convertListToSet(List<?> sourceList, Class<T> destinationType) {
        Assert.notNull(sourceList, "Cannot convert null list.");
        Set<T> destinationSet = new HashSet<>();
        for (Object source : sourceList) {
            T destination = map(source, destinationType);
            destinationSet.add(destination);
        }
        return destinationSet;
    }

    public ModelMapper emptyMapper() {
        return this.emptyModelMapper;
    }

    public ModelMapper mainMapper() {
        return this.mainModelMapper;
    }

}
