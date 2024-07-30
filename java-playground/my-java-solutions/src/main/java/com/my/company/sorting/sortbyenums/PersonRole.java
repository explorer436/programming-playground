package com.my.company.sorting.sortbyenums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PersonRole {
  CHILD(0),
  PARENT(1),
  GRANDPARENT(2);

  private final int hierarchy;
}
