// PSI_ELEMENT: org.jetbrains.kotlin.psi.KtNamedFunction
// OPTIONS: usages

class B(val n: Int) {
    operator fun <caret>get(i: Int) = ""
    operator fun set(i: Int, s: String) {}
    class Key
}

fun test() {
    B(1).get(2)
    B(1)[2]
    val b = B(2)
    b[3] = "a"
}

typealias DescriptorData = C<B.Key>

class C<T>


// IGNORE_FIR_LOG