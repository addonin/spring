package com.epam.spring.core.services.impl;

import com.epam.spring.core.context.TestCoreApplicationContext;
import com.epam.spring.core.domain.Auditorium;
import com.epam.spring.core.services.AuditoriumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author dimon
 * @since 06/02/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestCoreApplicationContext.class})
public class AuditoriumServiceImplTest {

    private AuditoriumService auditoriumService = new AuditoriumServiceImpl();

    @Test
    public void shouldReturnAuditoriums() throws Exception {

        List<Auditorium> auditoriums =
                new ArrayList<>(Collections.singletonList(new Auditorium("name", 10, Arrays.asList(1, 2, 3))));
        ReflectionTestUtils.setField(auditoriumService, "auditoriums", auditoriums);

        List<Auditorium> result = auditoriumService.getAuditoriums();

        assertTrue("Auditories should contain given result", auditoriums.containsAll(result));
    }
}