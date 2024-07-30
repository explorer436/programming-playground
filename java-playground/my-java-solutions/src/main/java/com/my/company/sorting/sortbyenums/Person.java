package com.my.company.sorting.sortbyenums;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
  private String name;
  private PersonRole personRole;
}
