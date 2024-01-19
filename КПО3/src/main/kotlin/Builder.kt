import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Класс, представляющий отчет.
 *
 * @property title Название отчета.
 * @property assignment Задание по отчету.
 * @property annotation Аннотация к отчету.
 * @property content Содержание отчета.
 * @property sources Список источников.
 * @property appendices Список приложений.
 */
@Serializable
data class Report(
    val title: String,
    val assignment: String,
    val annotation: String,
    val content: String,
    val sources: List<String>,
    val appendices: List<String>
)

/**
 * Класс-строитель отчета.
 *
 * @property title Название отчета.
 * @property assignment Задание по отчету.
 * @property annotation Аннотация к отчету.
 * @property content Содержание отчета.
 * @property sources Список источников.
 * @property appendices Список приложений.
 */
class ReportBuilder(
    private var title: String = "",
    private var assignment: String = "",
    private var annotation: String = "",
    private var content: String = "",
    private val sources: MutableList<String> = mutableListOf(),
    private val appendices: MutableList<String> = mutableListOf()
) {
    /**
     * Устанавливает название отчета.
     *
     * @param title Название отчета.
     * @return Текущий экземпляр [ReportBuilder].
     */
    fun setTitle(title: String): ReportBuilder {
        this.title = title
        return this
    }

    /**
     * Устанавливает задание по отчету.
     *
     * @param assignment Задание по отчету.
     * @return Текущий экземпляр [ReportBuilder].
     */
    fun setAssignment(assignment: String): ReportBuilder {
        this.assignment = assignment
        return this
    }

    /**
     * Устанавливает аннотацию к отчету.
     *
     * @param annotation Аннотация к отчету.
     * @return Текущий экземпляр [ReportBuilder].
     */
    fun setAnnotation(annotation: String): ReportBuilder {
        this.annotation = annotation
        return this
    }

    /**
     * Устанавливает содержание отчета.
     *
     * @param content Содержание отчета.
     * @return Текущий экземпляр [ReportBuilder].
     */
    fun setContent(content: String): ReportBuilder {
        this.content = content
        return this
    }

    /**
     * Добавляет источник к отчету.
     *
     * @param source Источник.
     * @return Текущий экземпляр [ReportBuilder].
     */
    fun addSource(source: String): ReportBuilder {
        this.sources.add(source)
        return this
    }

    /**
     * Добавляет приложение к отчету.
     *
     * @param appendix Приложение.
     * @return Текущий экземпляр [ReportBuilder].
     */
    fun addAppendix(appendix: String): ReportBuilder {
        this.appendices.add(appendix)
        return this
    }

    /**
     * Строит и возвращает готовый отчет.
     *
     * @return Готовый отчет.
     */
    fun build(): Report {
        return Report(title, assignment, annotation, content, sources.toList(), appendices.toList())
    }
}

fun main() {
    // Пример использования
    val report = ReportBuilder()
        .setTitle("Research Report")
        .setAssignment("Study the impact of technology on society.")
        .setAnnotation("This report explores the various ways in which technology influences our daily lives.")
        .setContent("The report contains in-depth analysis and findings from extensive research.")
        .addSource("Smith, J. (2022). The Tech Revolution. TechPress.")
        .addSource("Doe, A. (2021). The Social Impact of Technology. SocialScience Journal.")
        .addAppendix("Appendix A: Survey Results")
        .addAppendix("Appendix B: Interview Transcripts")
        .build()

    // Преобразование отчета в JSON
    val jsonReport = Json.encodeToString(report)
    println(jsonReport)
}
