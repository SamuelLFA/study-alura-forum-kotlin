package com.samuellima.forum_alura.controller

import com.samuellima.forum_alura.dto.TopicView
import com.samuellima.forum_alura.dto.form.CreateTopicForm
import com.samuellima.forum_alura.dto.form.UpdateTopicForm
import com.samuellima.forum_alura.mapper.CreateTopicFormMapper
import com.samuellima.forum_alura.mapper.TopicViewMapper
import com.samuellima.forum_alura.model.Topic
import com.samuellima.forum_alura.service.TopicService
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(
    private val topicService: TopicService,
    private val topicViewMapper: TopicViewMapper,
    private val createTopicFormMapper: CreateTopicFormMapper
) {

    @GetMapping
    @Cacheable("allTopics")
    fun list(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 5, sort = ["createdAt"], direction = Sort.Direction.DESC) pagination: Pageable
    ): ResponseEntity<Page<TopicView>> {
        val listOfTopics = topicService.list(courseName, pagination)

        val response = listOfTopics.map {
            topicViewMapper.map(it)
        }
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable id: Long): ResponseEntity<Topic> {
        val topic = topicService.getById(id)

        return ResponseEntity.ok(topic)
    }

    @PostMapping
    @CacheEvict(value = ["allTopics"], allEntries = true)
    fun create(
        @RequestBody @Valid request: CreateTopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topic = createTopicFormMapper.map(request)
        topicService.create(topic)
        val topicView = topicViewMapper.map(topic)

        val uri = uriBuilder.path("topics/{id}").buildAndExpand(topic.id).toUri()
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(topicView)
    }

    @PutMapping("/{id}")
    @CacheEvict(value = ["allTopics"], allEntries = true)
    fun update(@RequestBody @Valid request: UpdateTopicForm, @PathVariable id: Long): ResponseEntity<TopicView> {
        val topicUpdated = topicService.update(id, request)
        val topicView = topicViewMapper.map(topicUpdated)

        return ResponseEntity.status(HttpStatus.OK).body(topicView)
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = ["allTopics"], allEntries = true)
    fun remove(@PathVariable id: Long): ResponseEntity<Void> {
        topicService.delete(id)

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}