import java.util.concurrent.atomic.AtomicInteger

class UserDao {
    val users = hashMapOf(
        0 to User(nome = "Viviane", email = "vivi@gmail.com", id = 0),
        1 to User(nome = "Patricia", email = "pat@gmail.com", id = 1),
        2 to User(nome = "Sil", email = "sil@gmail.com", id = 2),
        3 to User(nome = "Mandy", email = "mandy@gmail.com", id = 3),
        4 to User(nome = "Lu", email = "lu@gmail.com", id = 4),
        5 to User(nome = "Lari", email = "lari@gmail.com", id = 5),
        6 to User(nome = "Reci", email = "reci@gmail.com", id = 6),
        7 to User(nome = "Juca", email = "juca@gmail.com", id = 7),
        8 to User(nome = "Bil", email = "bil@gmail.com", id = 8),
        9 to User(nome = "Dil", email = "dil@gmail.com", id = 9),
        10 to User(nome = "Gil", email = "gil@gmail.com", id = 10),
    )

    var lastId: AtomicInteger = AtomicInteger(users.size -1)

    // salvar
    fun save(nome: String, email: String) {
        val id = lastId.incrementAndGet()
        users.put(id, User(nome = nome, email = email, id = id))
    }

    // procurar um User por id
    fun findById(id: Int): User? {
        return users[id]
    }

    // procurar por email
    fun findByEmail(email: String): User? {
        return users.values.find { it.email == email}
    }

    // atualizar o User
    fun update(id: Int, user: User) {
        users.put(id, User(nome = user.nome, email = user.email, id = id ))
    }

    // deletar um User
    fun delete(id: Int) {
        users.remove(id)
    }
}