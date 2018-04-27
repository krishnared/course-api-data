package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

//	private List<Topic> topics = new ArrayList<>(
//			Arrays.asList(new Topic("Spring", "Spring FrameWork", "Spring Framework Description"),
//					new Topic("Java", "Core Java", "Core JAVA description"),
//					new Topic("MultiLevel", "Advance Java", "Spring description")));
	// This will generate the Json Values which maps with the properties

	public List<Topic> getAllTopics() {
		// return topics;
		List<Topic> topics = new ArrayList<>();

		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	// Get
	public Topic getTopic(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();

	}

	// Add
	public void addTopic(Topic topic) {
		// topics.add(topic);
		topicRepository.save(topic);
	}

	// Update
	public void updateTopic(String id, Topic topic) {

		topicRepository.save(topic);
		// Save can do update and add methods

	}

	// Delete
	public void deleteTopic(String id) {
		// topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}

}

/*
 * Bussiness Service -> TYPICALLY SINGLETON's When the application starts up,
 * Spring creates the instance of this service And it keep(or) register in
 * memory. Other controllers, Classes which depend on this service When it is
 * asked like, Hey Spring i need that service, It will be injected to those
 * classes
 */