import java.text.DecimalFormat
import kotlin.system.exitProcess

fun main() {

    do {

    println("INGRESE UNA OPCION")
    println("1.CALIFICACION")
    println("2.NUMEROS INDEFINIDOS")
    println("3.SALIR")

    var menu = readln().toInt()

    when(menu) {
        1 -> {
            var notas = arrayListOf<Double>()
            var totalnotas = 0.0


            for (i in 1 .. 5) {

                println("INGRESE CALIFICACION DE 0 a 5")
                var nota = readln().toDouble()
                if (nota > 5 || nota < 0) {
                    println("NOTA NO VALIDA")
                    println("INGRESA DE NUEVO LA NOTA")
                    nota = readln().toDouble()
                } else {
                    notas.add(nota)
                }
            }

            var notaBaja = notas[0]
            var notaAlta = notas[0]

            for (i in 0 until notas.size) {
                totalnotas += notas[i]
            }

            for (i in 1 until notas.size) {
                if (notaBaja > notas[i]) {
                    notaBaja = notas[i]
                }
                if (notaAlta < notas[i]) {
                    notaAlta = notas[i]
                }
            }

            var promedio = totalnotas / notas.size

            println(
                """
        EL PROMEDIO DE LAS NOTAS ES: $promedio
        LA NOTA MAS BAJA ES: $notaBaja
        LA NOTA MAS ALTA ES: $notaAlta
        
    """.trimIndent()
            )
            println("NOTAS POR DEBAJO DE 3")
            for (i in 0 until notas.size) {
                if (notas[i] < 3) {
                    println(notas[i])
                }
            }
        }

        2 -> {
            var todosNumeros = arrayListOf<Double>()
            var sumaNum = 0.0

            do {
                println("INGRESE UN NUMERO:")
                var num = readln().toDouble()
                todosNumeros.add(num)

            } while (num != 0.0)

            for (i in 0 until todosNumeros.size){
                sumaNum += todosNumeros[i]
            }

            var promedio = sumaNum / todosNumeros.size
            var raiz = Math.sqrt(sumaNum)

            println("""
               LA SUMATORIA DE LOS NUMEROS ES: $sumaNum
               EL PROMEDIO DE LOS NUMEROS ES: $promedio
               LA RAIZ DE LA SUMATORIA ES: ${DecimalFormat("#.###").format(raiz)}
               
            """.trimIndent())
        }
        3-> exitProcess(0)


    }

    }while (menu > 0 && menu < 4)
}