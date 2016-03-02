import com.ttnd.linksharing.Constants
import com.ttnd.linksharing.DocumentResource
import com.ttnd.linksharing.LinkResource
import com.ttnd.linksharing.ReadingItem
import com.ttnd.linksharing.ResourceRating
import com.ttnd.linksharing.Resource
import com.ttnd.linksharing.Seriousness
import com.ttnd.linksharing.Subscription
import com.ttnd.linksharing.Topic
import com.ttnd.linksharing.User
import com.ttnd.linksharing.Visibility

import javax.annotation.Resource

class BootStrap {
    def grailsApplication

    def init = { servletContext ->
        println(grailsApplication.config.grails.sample)
        List<User> users = createUsers()
        List<Topic> topics = createTopic(users)
        List<com.ttnd.linksharing.Resource> resources = createResource(topics)
        subscriptionTopic(users, topics)
        List<ReadingItem> readingItems = createReadingItems()
        List<ResourceRating> resourceRatings = createResourceRatings(readingItems)
        // validate(users.first()) //ask
    }

    List<User> createUsers() {
        List<User> users = []

        User user = User.findByEmail(Constants.USER_EMAIL)
        User user1 = User.findByEmail(Constants.ADMIN_EMAIL)
        try {
            if (!(user)) {
                user = new User(firstName: "sona", lastName: "kumra", email: Constants.USER_EMAIL, password: Constants.PASSWORD, username: "sonakumra", confirmPassword: Constants.PASSWORD, active: true)
                user.confirmPassword = "default"
                if (user.save(flush: true, failOnError: true)) {
                    users.add(user)
                    log.info "User ${user} saved successfully"
                } else {
                    log.error "Error saving user : ${user.errors.allErrors}"
                }
            }
            if (!(user1)) {

                user1 = new User(firstName: "madhav", lastName: "kumra", email: Constants.ADMIN_EMAIL, password: Constants.PASSWORD, username: "sonakumra", admin: true, confirmPassword: Constants.PASSWORD)
                user1.confirmPassword = "default"
                if (user1.save(flush: true, failOnError: true)) {
                    users.add(user1)
                    log.info "User ${user1} saved successfully"
                } else {
                    log.error "Error saving user : ${user1.errors.allErrors}"
                }
            }


            users
        }catch (Exception e){
            log.info e.message
        }
    }

    List<Topic> createTopic(List<User> users) {

        List<Topic> topics = []
        users.each { User user ->
            Integer countTopics = Topic.countByCreatedBy(user)
            if (!countTopics) {
                log.info "Creating 5 Topics for user ${user}"
                ['Grails', 'Java', 'NodeJS', 'AngularJS', 'Gradle'].each {
                    Topic topic = new Topic(name: "Topic${it}", visibility: Visibility.PRIVATE, createdBy: user)
                    if (topic.save(flush: true, failOnError: true)) {
                        log.info "Topic ${topic} saved for user ${user}"
                        user.addToTopics(topic)
                        topics.add(topic)
                    } else {
                        log.info "Topic ${topic} cannot be saved"
                    }
                }
            } else {
                log.info "User ${user} already have some topics created "

            }
        }
        return topics

    }

    void logRecords(List<Topic> topics) {
        topics.each { Topic user ->
            log.info "---${Topic.name}----"
        }
    }

    List<com.ttnd.linksharing.Resource> createResource(List<Topic> topics) {
        List<com.ttnd.linksharing.Resource> resources = []

        topics.each { Topic topic ->
            Integer countResources = com.ttnd.linksharing.Resource.countByTopic(topic)
            if (!countResources) {
                2.times {
                    com.ttnd.linksharing.Resource documentResource = new DocumentResource(description: "topic ${topic} doc", createdBy: topic
                            .createdBy, filePath: "file/path", topic: topic)
                    com.ttnd.linksharing.Resource linkResource = new LinkResource(description: "topic ${topic} link", createdBy: topic
                            .createdBy, url: "https://www.google.co.in", topic: topic)
                    if (documentResource.save(flush: true, failOnError: true)) {
                        log.info "document resource ${documentResource} saved"
                        resources.add(documentResource)
                        topic.addToResources(documentResource)
                    } else {
                        log.info "document resource ${documentResource} not saved"
                    }
                    if (linkResource.save(flush: true, failOnError: true)) {
                        log.info "document resource ${linkResource} saved"
                        resources.add(linkResource)
                        topic.addToResources(linkResource)
                    } else {
                        log.info "document resource ${linkResource} not saved"
                    }
                }
            }
        }
        return resources
    }

    void subscriptionTopic(List<User> users, List<Topic> topics) {
        // List<User> users = User.list()
        // List<Topic> topics = Topic.list()
        List<Subscription> subscriptions = Subscription.list()

        users.each {
            user ->
                topics.each
                        {
                            topic ->
                                if (!Subscription.findByUserAndTopic(user, topic)&&topic.createdBy!=user) {
                                    Subscription subscription = new Subscription(user: user, topic: topic, seriousness: Seriousness.VERY_SERIOUS)

                                    if (subscription.save())
                                        log.info "${subscription} saved successfully"
                                    else
                                        log.error "Error saving ${subscription.errors.allErrors}"
                                }
                        }
        }
    }

    List<ReadingItem> createReadingItems() {
        List<User> users = User.list()
        List<Topic> topics = Topic.list()
        List<com.ttnd.linksharing.Resource> resources = com.ttnd.linksharing.Resource.list()
        List<ReadingItem> readingItems = []

        users.each { user ->
            topics.each { topic ->
                if (Subscription.findByUserAndTopic(user, topic)) {
                    topic.resources.each { resource ->
                        if (resource.createdBy != user && !user.readingItems?.contains(resource)) {
                            ReadingItem readingItem = new ReadingItem(user: user, resources: resource, isRead: false)
                            if (readingItem.validate()) {
                                readingItem.save(flush: true)
                                readingItems.add(readingItem)
                                user.addToReadingItems(readingItem)
                                log.info "${readingItem} saved successfully"
                            } else
                                log.error "Error saving ${readingItem.errors.allErrors}"
                        }
                    }
                }
            }
           // user.save()
        }

        return readingItems
    }
    List<ResourceRating> createResourceRatings(List<ReadingItem> readingItems) {
        List<User> users = User.list()
        List<ResourceRating> resourceRatings = []

        users.each { user ->
            user.readingItems.each { item ->
                if (!item.isRead) {
                    ResourceRating resourceRating = new ResourceRating(user: item.user, resources: item.resources, score: 3)
                    if (resourceRating.validate()) {
                        resourceRating.save()
                        resourceRatings.add(resourceRating)
                        log.info("....Done Successfully Resource Rating....${item}")
                    } else {
                        log.info("Sorry......${resourceRating.errors.allErrors}")

                    }

                }
            }
        }
        resourceRatings
    }

    def destroy = {
    }
}
