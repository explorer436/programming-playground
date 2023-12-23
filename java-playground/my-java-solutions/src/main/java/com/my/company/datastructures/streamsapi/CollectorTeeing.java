package com.my.company.datastructures.streamsapi;

import java.util.Objects;

public class CollectorTeeing {

  /** Question : Is this a java-12 only feature and not available in java 8? */

  /*public static void main(String[] args) {

  	List<Integer> numbers = Arrays.asList(42, 4, 2, 24);
         Range range = numbers.stream()
             .collect(Collectors.teeing(Collectors.minBy(Integer::compareTo), Collectors.maxBy(Integer::compareTo), (min, max) -> new Range(min.orElse(null), max.orElse(null))));

  }*/

  /** Represents a closed range of numbers between {@link #min} and {@link #max}, both inclusive. */
  private static class Range {

    private final Integer min;

    private final Integer max;

    Range(Integer min, Integer max) {
      this.min = min;
      this.max = max;
    }

    Integer getMin() {
      return min;
    }

    Integer getMax() {
      return max;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Range range = (Range) o;
      return Objects.equals(getMin(), range.getMin()) && Objects.equals(getMax(), range.getMax());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getMin(), getMax());
    }

    @Override
    public String toString() {
      return "Range{" + "min=" + min + ", max=" + max + '}';
    }
  }
}
