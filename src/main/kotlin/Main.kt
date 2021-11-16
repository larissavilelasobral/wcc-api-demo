import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

fun main(){
//    val app = Javalin.create().start(7000)
//    app.get("/wcc") { ctx -> ctx.result("Olá mundo") }

//    val malu = User(nome = "Maria Luiza", email = "malu@wcc.com", id = 1)
//    val newNomeMalu = malu.copy(id = 5)
//
//    println(malu)
//    println(newNomeMalu)

    val userDao = UserDao()

    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, ctx -> e.printStackTrace()}
        error(404) { ctx -> ctx.json("NOT FOUND") }
    }.start(7000)

    app.routes {
        // mostrar todos os usuarios
        get("/users") { ctx ->
            ctx.json(userDao.users)
        }

        // buscar usuarios por id
        get("/users/{user-id}") { ctx ->
            ctx.json(userDao.findById(ctx.pathParam("user-id").toInt())!!)
        }
    }

}
