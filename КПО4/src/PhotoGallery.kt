data class Photo(
    val id: Int,
    val title: String,
    val description: String,
    val photographer: String,
    val location: String
)

class Photos(private val novellas: MutableList<Photo> = mutableListOf()) : Iterable<Photo> {
    override fun iterator(): Iterator<Photo> = PhotosIterator(novellas)
}

class PhotosIterator(private val novellas: MutableList<Photo> = mutableListOf(), private var current: Int = 0) :
    Iterator<Photo> {
    override fun hasNext(): Boolean = novellas.isNotEmpty()
    override fun next(): Photo {
        val novella = novellas[current]
        current = (current + 1) % novellas.size
        return novella
    }
}

fun main() {
    val photoList = mutableListOf(
        Photo(1, "Закат на пляже", "Прекрасный закат на берегу океана", "John Smith", "Пляж"),
        Photo(2, "Городские огни", "Ночной вид на городские огни", "Emily Johnson", "Город"),
        Photo(3, "Горные вершины", "Величественные горные вершины", "Michael Brown", "Горы")
    )
    val photoCollection = Photos(photoList)
    for (photo in photoCollection) {
        println(photo)
    }
}