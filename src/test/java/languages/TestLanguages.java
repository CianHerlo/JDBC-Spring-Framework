package languages;

import cian.herlihy.r00205604.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class TestLanguages {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testFrench() {
        String message = applicationContext.getMessage("welcome", null, Locale.FRENCH);
        Assertions.assertEquals("Cian Herlihy - R00205604 - Affectation du framework JDBC Spring", message);
    }

    @Test
    public void testGerman() {
        String message = applicationContext.getMessage("welcome", null, Locale.GERMAN);
        Assertions.assertEquals("Cian Herlihy - R00205604 - JDBC Spring Framework-Zuweisung", message);
    }

    @Test
    public void testMessagesBean() {
        Assertions.assertNotNull(applicationContext.getBean(MessageSource.class));
    }
}
