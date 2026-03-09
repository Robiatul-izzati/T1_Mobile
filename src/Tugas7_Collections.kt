//data class
data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

//menentukan grade
fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }
}

fun main() {
    //List 10 mahasiswaa
    val mahasiswa = listOf(
        NilaiMahasiswa("F1D0221029","Abdul Aqil Murtadho","Pemrograman",92),
        NilaiMahasiswa("F1D02310023","Robiatul Izzati","Pemrograman",89),
        NilaiMahasiswa("F1D02310035","Alysa Meliana","Pemrograman",69),
        NilaiMahasiswa("F1D02310062","Julia Ariyani","Pemrograman",80),
        NilaiMahasiswa("F1D02310086","Nurmiftah Azis","Pemrograman",82),
        NilaiMahasiswa("F1D02310081","M Rendi Maulana","Pemrograman",90),
        NilaiMahasiswa("F1D02310129","Nur Adinda Juniarti","Pemrograman",85),
        NilaiMahasiswa("F1D02310134","Rafly Ridho Sukardi","Pemrograman",88),
        NilaiMahasiswa("F1D02310145","Maulida Citra Illiyyin","Pemrograman",49),
        NilaiMahasiswa("F1D02310146","M Rizky Destiawansyah","Pemrograman",59)
    )

    println("===== DATA NILAI MAHASISWA =====")
    println(String.format("%-3s %-12s %-22s %-15s %-5s", //biar rapi
        "No","NIM","Nama","MataKuliah","Nilai"))

    mahasiswa.forEachIndexed { i, m ->
        println(String.format("%-3d %-12s %-22s %-15s %-5d",
            i+1, m.nim, m.nama, m.mataKuliah, m.nilai))
    }

    //filter mahasiswa
    //lulus
    val lulus = mahasiswa.filter { it.nilai >= 70 }
    println("\n===== MAHASISWA LULUS =====")
    lulus.forEach { println("${it.nama} - ${it.nilai}") }

    //tidak lulus
    val tidakLulus = mahasiswa.filter { it.nilai < 70 }
    println("\n===== MAHASISWA TIDAK LULUS =====")
    tidakLulus.forEach { println("${it.nama} - ${it.nilai}") }

    println("\n===== STATISTIK =====")
    println("Total Mahasiswa: ${mahasiswa.count()}")
    println("Jumlah Lulus: ${mahasiswa.count { it.nilai >= 70 }}")

    val rata = mahasiswa.map { it.nilai }.average()
    println("Rata-rata nilai: $rata")

    //nilai tertinggi
    val tertinggi = mahasiswa.maxByOrNull { it.nilai }
    println("Nilai tertinggi: ${tertinggi?.nama} (${tertinggi?.nilai})")
    //nilai terendah
    val terendah = mahasiswa.minByOrNull { it.nilai }
    println("Nilai terendah: ${terendah?.nama} (${terendah?.nilai})")

    //sorted berdasarkan nilai
    //ascending
    val asc = mahasiswa.sortedBy { it.nilai }
    println("\n===== URUT NILAI ASCENDING =====")
    asc.forEach { println("${it.nama} - ${it.nilai}") }
    //descending
    val desc = mahasiswa.sortedByDescending { it.nilai }
    println("\n===== URUT NILAI DESCENDING =====")
    desc.forEach { println("${it.nama} - ${it.nilai}") }

    println("\n===== MAHASISWA PER GRADE =====")
    val groupGrade = mahasiswa.groupBy { getGrade(it.nilai) }
    val urutanGrade = listOf("A","B","C","D","E")

    urutanGrade.forEach { grade ->
        val listMahasiswa = groupGrade[grade] ?: emptyList()

        println("Grade $grade : ${listMahasiswa.size} mahasiswa")

        listMahasiswa.forEach {
            println(" - ${it.nama} (${it.nilai})")
        }

        println()
    }

    //cari mahasiswa
    println("\n===== SEARCH =====")
    val cari = mahasiswa.filter { it.nama.contains("ul", ignoreCase = true) }

    println("Hasil pencarian:")
    cari.forEach { println("${it.nama} - ${it.nilai}") }
}