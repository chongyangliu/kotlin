package languageVersion1_1

public fun useJavaMap() {
    java.util.HashMap<Int, Int>().values.removeIf { it < 5 }
}