class TreeNode(
    val key: Char,
    val children: MutableList<TreeNode>,
    var parent: TreeNode?,
) {
    fun accept(visitor: NodeVisitor) {
        visitor.visit(this)
        children.forEach { it.accept(visitor) }
    }
}

class Tree(
    var root: TreeNode? = null
) {
    fun parseTree(input: String) {
        var currentNode: TreeNode? = null
        for (item in input) {
            if (item == '(' || item == '{' || item == '[') {
                val node = TreeNode(item, mutableListOf(), currentNode)
                if (root == null) {
                    root = node
                } else {
                    currentNode?.children?.add(node)
                }
                currentNode = node
            } else if (item == ')' || item == '}' || item == ']') {
                currentNode = currentNode?.parent
            }
        }
    }

    fun traverse(node: TreeNode) {
        if (node == null) {
            return
        }
        print(node.key)
        for (item in node.children) {
            traverse(item)
        }
        if (node.key == '(') {
            print(node.key + 1)
        } else {
            print(node.key + 2)
        }
    }
}

interface NodeVisitor {
    fun visit(node: TreeNode)
}

class RemoveBracketVisitor : NodeVisitor {
    override fun visit(node: TreeNode) {
        if (node.key == '[') {
            node.children.clear()
        }
    }
}

class AddBracketVisitor : NodeVisitor {
    override fun visit(node: TreeNode) {
        if (node.key == '{') {
            node.children.add(TreeNode('(', mutableListOf(), node))
        }
    }
}


fun main() {
    println("Input:")
    val input = "([]({}()[])[()()])"
    println(input)
    val tree = Tree()
    tree.parseTree(input)
    println("Traverse:")
    tree.root?.let { tree.traverse(it) }
    val removeBracketVisitor = RemoveBracketVisitor()
    tree.root?.accept(removeBracketVisitor)
    val addBracketVisitor = AddBracketVisitor()
    tree.root?.accept(addBracketVisitor)
    println("\nVisited tree:")
    tree.root?.let { tree.traverse(it) }
}