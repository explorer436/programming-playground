package com.my.company.datastructures.maps;

import com.my.company.streamsapi.CollectionOperationsOnNonPrimitiveTypes;
import com.my.company.streamsapi.TestsHelper;
import com.my.company.streamsapi.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class TransformAListIntoAMap {

    public static void main(String[] args) {

        List<Person> people = TestsHelper.getPeople();

        CollectionOperationsOnNonPrimitiveTypes collectionOperationsOnNonPrimitiveTypes = new CollectionOperationsOnNonPrimitiveTypes();

        Map<String, String> actual = collectionOperationsOnNonPrimitiveTypes.groupPeopleByGender_GetFullNamesGrammatically(people);

        log.info("{}", actual);
    }

}

