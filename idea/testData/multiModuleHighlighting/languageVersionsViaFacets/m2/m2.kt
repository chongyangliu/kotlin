package languageVersion1_0

public fun useJavaMap() {
    java.util.HashMap<Int, Int>().values.<error descr="[UNRESOLVED_REFERENCE] Unresolved reference: removeIf">removeIf</error> { <error>it</error> < 5 }
}