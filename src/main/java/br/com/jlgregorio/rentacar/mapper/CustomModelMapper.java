package br.com.jlgregorio.rentacar.mapper;


import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomModelMapper {

    public static ModelMapper mapper = new ModelMapper();

    public static<Origin, Destination> Destination parseObject(Origin origin,
                                                               Class<Destination> destination){
        return mapper.map(origin, destination);
    }

    public static<Origin, Destination> List<Destination>
           parseObjectList(List<Origin> origins,
                    Class<Destination> destination){
           List<Destination> destinationList = new ArrayList<Destination>();
           for(Origin origin : origins){
               destinationList.add(mapper.map(origin, destination));
           }
           return destinationList;
    }

}
