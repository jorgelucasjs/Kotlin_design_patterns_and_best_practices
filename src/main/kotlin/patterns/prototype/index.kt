package patterns.prototype

enum class Role {
    ADMIN,
    SUPER_ADMIN,
    REGULAR_USER
}
data class User(
    val name: String,
    val role: Role,
    val permissions: Set<String>,
    val tasks: List<String>,
) {
    fun hasPermission(permission: String) = permission in permissions
}

val allUsers = mutableListOf<User>()
//fun createUser(name: String, role: Role) {
//    for (u in allUsers) {
//        if (u.role == role) {
//            allUsers += User(name, role, u.permissions, u.tasks)
//            return
//        }
//    }
//// Handle case that no other user with such a role exists
//}

//=========Starting from a prototype=========
//Here’s an example of how the copy() method can be used:

fun createUser(userName: String, role: Role) {
    for (u in allUsers) {
        if (u.role == role) {
            allUsers += u.copy(name = userName)
            return
        }
    }
// Handle case that no other user with such a role exists
}

