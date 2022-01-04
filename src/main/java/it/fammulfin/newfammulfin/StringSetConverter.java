package it.fammulfin.newfammulfin;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
@Converter
public class StringSetConverter implements AttributeConverter<Set<String>, String> {
  private static final String DELIMITER = " ";

  @Override
  public String convertToDatabaseColumn(Set<String> strings) {
    return String.join(DELIMITER, new TreeSet<>(strings));
  }

  @Override
  public Set<String> convertToEntityAttribute(String s) {
    return new TreeSet<>(Arrays.stream(s.split(DELIMITER)).toList());
  }
}
