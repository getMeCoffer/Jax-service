package com.test.api.resources;

import com.test.api.domain.Story;
import com.test.api.framework.Async;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Singleton
@Path("story")
@Produces(MediaType.APPLICATION_JSON)
public class StoryController {

    @Inject
    private Async async;

    // 创建一个静态的HashMap来存储故事
    private static final HashMap<Long, Story> storiesMap = new HashMap<>();

    static {
        // 在静态块中初始化故事列表
        Story story1 = new Story();
        story1.setId(1L);
        story1.setTitle("The Mystery of the Lost Key");
        story1.setContent("A thrilling adventure in search of a lost ancient key leading to a hidden treasure.");
        story1.setAuthor("Author 1");

        Story story2 = new Story();
        story2.setId(2L);
        story2.setTitle("Journey to the Unknown");
        story2.setContent("An exciting journey of a group of friends to an undiscovered island with mysterious secrets.");
        story2.setAuthor("Author 2");

        Story story3 = new Story();
        story3.setId(3L);
        story3.setTitle("The Last Wizard");
        story3.setContent("The tale of the last wizard on Earth fighting to save the magical world from extinction.");
        story3.setAuthor("Author 3");

        Story story4 = new Story();
        story4.setId(4L);
        story4.setTitle("Space Odyssey 3000");
        story4.setContent("A futuristic space journey narrating the adventures and challenges of intergalactic travel.");
        story4.setAuthor("Author 4");

        Story story5 = new Story();
        story5.setId(5L);
        story5.setTitle("Underwater Fantasia");
        story5.setContent("An underwater exploration story unveiling the mysteries and beauties of the oceanic depths.");
        story5.setAuthor("Author 5");

        // 将故事添加到HashMap中
        storiesMap.put(story1.getId(), story1);
        storiesMap.put(story2.getId(), story2);
        storiesMap.put(story3.getId(), story3);
        storiesMap.put(story4.getId(), story4);
        storiesMap.put(story5.getId(), story5);
    }

    @GET
    public List<Story> getStories() {
        return new ArrayList<>(storiesMap.values());
    }

    // 添加一个根据ID查找故事的方法
    @GET
    @Path("{id}")
    public Story getStoryById(@PathParam("id") Long id) {
        return storiesMap.get(id);
    }
}
