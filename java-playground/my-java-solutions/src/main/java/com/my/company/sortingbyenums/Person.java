package com.my.company.sortingbyenums;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
  private String name;
  private PersonRole personRole;
}
