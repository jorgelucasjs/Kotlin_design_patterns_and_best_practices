package patterns.abstract_factory

//O Abstract Factory é um padrão de design criacional que permite criar famílias de objetos
//relacionados sem especificar suas classes concretas. Em vez de instanciar objetos diretamente,
//o padrão define interfaces para a criação de produtos, e as subclasses concretas implementam
//essas interfaces para produzir variações específicas dos produtos.

//Let’s start by defining the interfaces for the server configuration:
interface Property{
    val name: String
    val value: Any
}


interface ServerConfiguration{
    val properties: List<Property>
}

//Next, we can provide basic implementations for these interfaces:
data class PropertyImpl(
    override val name: String,
    override val value: Any
): Property

data class ServerConfigurationImpl(
    override val properties: List<Property>
) : ServerConfiguration

//Now, let’s write our first Factory Method, which will create a Property object based on a string:
fun property(prop: String): Property{
    val (name, value) = prop.split(":")

    return when(name){
        "port"-> PropertyImpl(name, value.trim().toInt())
        "environment" -> PropertyImpl(name, value.trim())
        else -> throw IllegalArgumentException("Unknown property: $name")
    }

}

fun abstract_factory(){
    val portProperty = property("port: 8080")
    val environmentProperty = property("environment: production")
}