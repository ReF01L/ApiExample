import java.net.URL

class Sender() {
    companion object {
        fun send(url : String) : String {
            return try {
                URL(url).openStream().bufferedReader().use{ it.readText() }
            } catch (e : Exception) {
                "not correct url"
            }
        }
    }
}

open class Main{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val json = Sender.send("https://api.coingecko.com/api/v3/ping") // Любой адресс(список сделаю позже).
            println(json)
        }
    }
}