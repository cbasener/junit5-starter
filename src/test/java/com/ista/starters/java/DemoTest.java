package com.ista.starters.java;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;

class DemoTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void testValueSource(int value) {
    assertThat(value).isGreaterThan(0);
  }

  @ParameterizedTest
  @NullSource
  void testNullSource(Integer value) {
    assertThat(value).isNull();
  }

  @ParameterizedTest
  @NullAndEmptySource
  void testNullAndEmptySource(String value) {
    assertThat(value).isNullOrEmpty();
  }

  @ParameterizedTest
  @CsvSource({"1, 1, 2", "2, 3, 5"})
  void testCsvSource(int left, int right, int expected) {
    assertThat(left + right).isEqualTo(expected);
  }

  @ParameterizedTest
  @EnumSource(Type.class)
  void testEnumSource(Type type) {
    assertThat(type).isIn(Type.A, Type.B);
  }

  enum Type {
    A, B
  }
}
