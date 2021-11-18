package org.spring.controller;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.spring.model.dto.website.WebsiteDto;
import org.spring.service.StackOverflowService;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StackOverflowControllerTest {
    @Mock
    private StackOverflowService stackOverflowService;

    @InjectMocks
    private StackOverflowController stackOverflowController;

    @Test
    public void getAllWebsites() {
        when(stackOverflowService.findAllPaging(0)).thenReturn(ImmutableList.of(
                new WebsiteDto("stackoverflow", "", "", "", ""),
                new WebsiteDto("serverfault", "", "", "", "")));

        List<WebsiteDto> list = stackOverflowController.getAllWebsitesPaging(0).getBody();

        verify(stackOverflowService).findAllPaging(0);

        List<WebsiteDto> list1 = asList(
                new WebsiteDto("stackoverflow", "", "", "", ""),
                new WebsiteDto("serverfault", "", "", "", ""));
        Assert.assertEquals(list, list1);
    }
}