fun main() {
var typeCard = "VK Pay"
val previousSumma = 0.0

println("Задание №2. Денежные переводы")
print("Введите сумму перевода в рублях: ")
val amount: Float = readLine()!!.toFloat()   //Ввод суммы перевода

//Первый символ карт для определения типа карты = 2 -MIR, 4 -VISA, 5 -Master, 6 -Maestro, 9 -VK Pay???
print("Введите номер (первую цифру) карты для перевода: ")
val numberCard = readLine()!!.toCharArray()           //Ввод номера карты для определения ТИПА КАРТЫ
val symbolCard = (numberCard.first())
when (symbolCard.toString()) {
    "2" -> typeCard = "MIR Card"
    "4" -> typeCard = "VISA Card"
    "5" -> typeCard = "MasterCard"
    "6" -> typeCard = "MaestroCard"
    else -> typeCard = "VK Pay"
}

//расчет комиссии и суммы перевода
calculationCommission(typeCard, previousSumma, amount)
println("Расчет завершен")

}

fun calculationCommission(typeCard: String, previousSumma: Double, amount: Float): Int {
    val procentKomissMaster = 0.6         // процент комиссии карт Master
    val summaMinKomissMaster = 20         // сумма комиссии Master
    val procentKomissVisaMir = 0.75       // процент комиссии карт VISA / MIR
    val summaMinKomissVisaMir = 35.0      // сумма мин комиссии карт VISA / MIR
    val maxLimitTodayCard = 150_000          // максимальный лимит в СУТКИ по картам (кроме VK Pay)
    val maxLimitMonthCard = 600_000          // максимальный лимит в МЕСЯЦ по картам (кроме VK Pay)
    val maxLimitTodayVKPay = 15_000          // максимальный лимит в СУТКИ VK Pay
    val maxLimitMonthVKPay = 40_000          // максимальный лимит в МЕСЯЦ VK Pay
    var summaTransfer = 0.0                  // сумма перевода
    var summaCommission = 0                  // сумма комиссии

    println(typeCard) //вывести на экран ТИП карты

    if (typeCard == "VK Pay") {
        // проверка на месячный лимит для перевода
        if (amount < maxLimitMonthVKPay) {
            // проверка на суточный лимит для перевода
            if (amount < maxLimitTodayVKPay) {
                summaTransfer = amount - previousSumma
                println("Сумма перевода: $summaTransfer")
            } else {
                println("Превышен суточный лимит на перевод по карте VK Pay")
            }
        } else {
            println("Превышен месячный лимит на перевод по карте VK Pay")
        }
    }

    if ((amount + previousSumma) < maxLimitMonthCard) {
        if (amount < maxLimitTodayCard) {
            if (typeCard == "MIR Card" || typeCard == "VISA Card") {
                //расчет комиссии
                if ((amount / 100 * procentKomissVisaMir) < summaMinKomissVisaMir) {
                    summaTransfer = (amount - summaMinKomissVisaMir)
                    summaCommission = summaMinKomissVisaMir.toInt()
                } else {
                    summaTransfer = amount - (amount / 100 * procentKomissVisaMir)
                    summaCommission = (amount / 100 * procentKomissVisaMir).toInt()
                }
                println("Сумма перевода: $summaTransfer")
                println("Сумма комиссии: $summaCommission")
            }

            if (typeCard == "MasterCard" || typeCard == "MaestroCard") {
                summaTransfer = (amount - (amount / 100 * procentKomissMaster)) - summaMinKomissMaster
                summaCommission = ((amount / 100 * procentKomissMaster) + summaMinKomissMaster).toInt()
                println("Сумма комиссии: $summaCommission")
                println("Сумма перевода: $summaTransfer")
            }

        } else {
            println("Превышен лимит по карте по сумме перевода в сутки")
        }

    } else {
        println("Превышен лимит по карте по сумме перевода в месяц")
    }
    return summaCommission
}
