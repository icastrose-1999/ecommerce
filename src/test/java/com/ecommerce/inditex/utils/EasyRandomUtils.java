package com.ecommerce.inditex.utils;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EasyRandomUtils {

    /** The Constant easyRandom. */
    private final EasyRandom easyRandom = new EasyRandom(
        new EasyRandomParameters()
            .dateRange(
                OffsetDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toLocalDate(),
                OffsetDateTime.of(2030, 12, 31, 23, 59, 59, 999999999, ZoneOffset.UTC).toLocalDate()
            )
            .collectionSizeRange(1, 5) // Default range for collection sizes
            .stringLengthRange(5, 20) // Default range for string lengths
    );


    /**
     * Generate.
     *
     * @param <T> the generic type
     * @param clazz the clazz
     * @return the t
     */
    public <T> T generate(Class<T> clazz) {
        return easyRandom.nextObject(clazz);
    }


    /**
     * Generate list.
     *
     * @param <T> the generic type
     * @param clazz the clazz
     * @param size the size
     * @return the list
     */
    public <T> List<T> generateList(Class<T> clazz, int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> easyRandom.nextObject(clazz))
                .collect(Collectors.toList());
    }

    /**
     * Generate a random OffsetDateTime within the predefined range.
     *
     * @return a random OffsetDateTime
     */
    public OffsetDateTime generateRandomOffsetDateTime() {
        return easyRandom.nextObject(OffsetDateTime.class);
    }


    /**
     * Generate random offset date time between.
     *
     * @param start the start
     * @return the offset date time
     */
    public OffsetDateTime generateRandomOffsetDateTimeBetween(OffsetDateTime start, OffsetDateTime end) {
        EasyRandom customRandom = new EasyRandom(
            new EasyRandomParameters()
                .dateRange(start.toLocalDate(), end.toLocalDate())
        );
        return customRandom.nextObject(OffsetDateTime.class);
    }
}
