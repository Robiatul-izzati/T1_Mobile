//Robiatul izzati
fun main(){

    println("==== SISTEM PENILAIAN =====")

    //Input Mahasiswa
    //input nama
    print("Masukkan Nama Mahasiswa     : ")
    val nama = readLine()!!

    //input nilai
    print("Masukkan Nilai UTS (0-100)  : ")
    val uts = readLine()!!.toDouble()
    //validasi nilai
    if (uts !in 0.0..100.0){
        println("Nilai UTS harus antara 0 - 100")
        return
    }

    print("Masukkan Nilai UAS (0-100)  : ")
    val uas = readLine()!!.toDouble()
    //validasi nilai
    if (uts !in 0.0..100.0){
        println("Nilai UAS harus antara 0 - 100")
        return
    }

    print("Masukkan Nilai Tugas (0-100): ")
    val tugas = readLine()!!.toDouble()
    //validasi nilai
    if (uts !in 0.0..100.0){
        println("Nilai Tugas harus antara 0 - 100")
        return
    }

    //nilai akhir (UTS 30%, UAS 40%, dan Tugas 30%)
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    //konversi nilai ke huruf
    val grade = when (nilaiAkhir.toInt()) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }
    //keterangan nilai
    val keterangan = when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        else -> "Sangat Kurang"
    }

    //Status Kelulusan
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    println("\n==== HASIL  PENILAIAN ====")
    println("Nama        : $nama")
    println("Nilai UTS   : $uts (Bobot 30%)")
    println("Nilai UAS   : $uas (Bobot 40%)")
    println("Nilai Tugas : $tugas (Bobot 30%)")
    println("------------------------------")
    println("Nilai Akhir : $nilaiAkhir")
    println("Grade       : $grade")
    println("Keterangan  : $keterangan")
    println("Status      : $status")

    if (status == "LULUS") {
        println("\nSelamat! Anda dinyatakan LULUS")
    } else {
        println("\nMaaf! Anda dinyatakan TIDAK LULUS")
    }
}
