package pl.hetman.wiktoria.spring.learn.app.bookstore.isbngenerator;

import java.util.Random;
import java.util.logging.Logger;

public class IsbnGenerator {

    private static final Logger LOGGER = Logger.getLogger(IsbnGenerator.class.getName());

    //isbn 10-13 digits total
    // prexix - 978/979 depends on the year
    // group - depends on country - 83 in Poland
    // publisher 2-6 digits
    //title - pula numerow
    // pula 10 - 0-9
    // pula 100 - 00-99
    // pula 1000 - 000-999
    // pula 10000 - 0000-9999
    // pula 100000 - 00000-99999
    //check digit - suma cyfr pomnozonych przez ich pozycje, modulo 11, 10 prezentowane jako x

    public static String generateIsbn() {
        LOGGER.info("generateIsbn()");

        Long prefix = null;
        Long group = 83L;
        Long publisher = null;
        Long title = null;
        String checkDigit = null;
        String hyphen = "-";

        Random random = new Random();

        long generatePrefix = random.nextLong(10L);
        if (generatePrefix <= 5) {
            prefix = 978L;
        } else prefix = 979L;

        long generatePublisher = random.nextLong(999999L);
        if (generatePublisher < 10) {
            generatePublisher = random.nextLong(999999L);
        }
        publisher = generatePublisher;

        String publisherToString = "" + generatePublisher;
        int length = publisherToString.length();
        long generateTitle = 0;

        if (length < 10) {
            generateTitle = random.nextLong(9L);
        } else if (length >= 10 && length < 100) {
            generateTitle = random.nextLong(100L);
            if (generateTitle < 10) {
                generateTitle = random.nextLong(100L);
            }
        } else if (length >= 100 && length < 1000) {
            generateTitle = random.nextLong(1000L);
            if (generateTitle < 100) {
                generateTitle = random.nextLong(1000L);
            }
        } else if (length >= 1000 && length < 10000) {
            generateTitle = random.nextLong(10000L);
            if (generateTitle < 1000) {
                generateTitle = random.nextLong(10000L);
            }
        } else if (length >= 10000 && length < 100000) {
            generateTitle = random.nextLong(100000L);
            if (generateTitle < 10000) {
                generateTitle = random.nextLong(100000L);
            }
        } else if (length >= 100000 && length < 1000000) {
            generateTitle = random.nextLong(1000000L);
            if (generateTitle < 100000) {
                generateTitle = random.nextLong(1000000L);
            }
        }
        title = generateTitle;

        String positions = "" + prefix + group + publisher + title;

        int sum = 0;
        for (int i = 0; i < positions.length(); i++) {
            sum+=(i+1)*positions.charAt(i);
        }
        sum = sum%11;
        if(sum==10){
            checkDigit="X";
        } else {
            checkDigit=""+sum;
        }


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(prefix)
                .append(hyphen)
                .append(group)
                .append(hyphen)
                .append(publisher)
                .append(hyphen)
                .append(title)
                .append(hyphen)
                .append(checkDigit);

        LOGGER.info("generateIsbn(...)");
        return stringBuilder.toString();
    }

}
