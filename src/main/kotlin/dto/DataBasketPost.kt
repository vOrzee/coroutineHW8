package dto

import ru.netology.nmedia.dto.Author
import ru.netology.nmedia.dto.Comment
import ru.netology.nmedia.dto.Post

data class DataBasketPost(
    val post: Post,
    val comments: List<Comment>,
    var authors: Map<Long, Author> = mapOf()
) {
    private var authorsId: MutableSet<Long> = mutableSetOf()
    init {
        authorsId.add(post.authorId)
        for (i in 0..comments.lastIndex) {
            authorsId.add(comments[i].authorId)
        }
    }
    fun getAuthorsId() : List<Long> = authorsId.toList()

}
