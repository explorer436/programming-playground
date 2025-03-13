package com.my.company.sorting.objects.sortbyenums;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
  private String name;
  private PersonRole personRole;
}
