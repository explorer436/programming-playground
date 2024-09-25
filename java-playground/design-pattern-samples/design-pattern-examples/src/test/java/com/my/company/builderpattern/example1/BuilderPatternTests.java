package com.my.company.builderpattern.example1;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuilderPatternTests {

    @Test
    public void test1() {
        HouseBuilder concreteHouseBuilder = new ConcreteHouseBuilder();
        ConstructionEngineer engineer = new ConstructionEngineer(concreteHouseBuilder);
        House actual = engineer.constructHouse();

        House expected = new House();
        expected.setFoundation("Concrete, brick, and stone");
        expected.setStructure("Concrete, mortar, brick, and reinforced steel");
        expected.setRoof("Concrete and reinforced steel");
        expected.setPainted(true);
        expected.setFurnished(true);

        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));
    }

    @Test
    public void test2() {
        HouseBuilder prefabricatedHouseBuilder = new PrefabricatedHouseBuilder();
        ConstructionEngineer engineer = new ConstructionEngineer(prefabricatedHouseBuilder);
        House actual = engineer.constructHouse();

        House expected = new House();
        expected.setFoundation("Wood, laminate, and PVC flooring");
        expected.setStructure("Structural steels and wooden wall panels");
        expected.setRoof("Roofing sheets");
        expected.setPainted(false);
        expected.setFurnished(true);

        assertTrue(EqualsBuilder.reflectionEquals(expected, actual));
    }

}
