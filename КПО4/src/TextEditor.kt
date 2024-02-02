import java.util.*

class TextEditor {
    private val textStack = Stack<String>()
    private val currentText = StringBuilder()

    fun addText(text: String) {
        textStack.push(currentText.toString())
        currentText.append(text)
    }

    fun undo() {
        if (textStack.isNotEmpty()) {
            currentText.setLength(0)
            currentText.append(textStack.pop())
        } else {
            println("Нет сохраненных состояний для отката")
        }
    }

    fun getCurrentText(): String {
        return currentText.toString()
    }
}

fun main() {
    val textEditor = TextEditor()

    while (true) {
        println("Текущий текст: ${textEditor.getCurrentText()}")
        println("Введите команду: (добавить, откатить, выход)")
        when (readLine()) {
            "добавить" -> {
                print("Введите текст для добавления: ")
                val input = readLine() ?: ""
                textEditor.addText(input)
            }
            "откатить" -> {
                textEditor.undo()
            }
            "выход" -> return
            else -> println("Неизвестная команда")
        }
    }
}