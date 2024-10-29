package patterns.builder

data class RegularMail(
    val to: List<String>,
    val cc: List<String>?,
    val title: String?,
    val message: String?,
    val important: Boolean,
)

//val mail = RegularMail(
//    listOf("manager@company.com"), // To
//    null, // CC
//    "Ping", // Title
//    null, // Message,
//    true // Important
//)


class MailBuilder {
    private var to: List<String> = listOf()
    private var cc: List<String> = listOf()
    private var title: String = ""
    private var message: String = ""
    private var important: Boolean = false
    private var recepients: List<String> = listOf()

    data class Mail internal constructor(
        val to: List<String>,
        val cc: List<String>?,
        val title: String?,
        val message: String?,
        val important: Boolean
    )

    fun build(): Mail {
        if (to.isEmpty()) {
            throw RuntimeException("To property is empty")
        }
        return Mail(to, cc, title, message, important)
    }

    fun message(message: String): MailBuilder {
        this.message = message
        return this
    }

    fun recepients(recepients: List<String>): MailBuilder {
        this.recepients = recepients
        return this
    }

}


val mail = MailBuilder()
    .recepients(listOf("hello@world.com"))
    .message("Hello")
    .build()


//==============[Fluent setters]=============

data class MailFluent(
    val to: List<String>,
    private var _message: String? = null,
    private var _cc: List<String>? = null,
    private var _title: String? = null,
    private var _important: Boolean? = null
) {
    fun message(message: String) = apply {
        _message = message
    }

}


val mail2 =
    MailFluent(listOf("manager@company.com"))
        .message("ping")



data class MailApply(
    val to: List<String>,
    var message: String? = null,
    var cc: List<String>? = null,
    var title: String? = null,
    var important: Boolean? = null
)

val mail3 = MailApply(listOf("manager@company.com")).apply {
    message = "You've been promoted"
    title = "Come to my office"
}

//===================Default arguments======================
data class MailDefaults(
    val to: List<String>,
    val cc: List<String> = listOf(),
    val title: String = "",
    val message: String = "",
    val important: Boolean = false,
)













