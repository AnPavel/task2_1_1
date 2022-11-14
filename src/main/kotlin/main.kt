fun main() {
var typeCard = "VK Pay"
val previousSumma = 0.0

println("������� �2. �������� ��������")
print("������� ����� �������� � ������: ")
val amount: Float = readLine()!!.toFloat()   //���� ����� ��������

//������ ������ ���� ��� ����������� ���� ����� = 2 -MIR, 4 -VISA, 5 -Master, 6 -Maestro, 9 -VK Pay???
print("������� ����� (������ �����) ����� ��� ��������: ")
val numberCard = readLine()!!.toCharArray()           //���� ������ ����� ��� ����������� ���� �����
val symbolCard = (numberCard.first())
when (symbolCard.toString()) {
    "2" -> typeCard = "MIR Card"
    "4" -> typeCard = "VISA Card"
    "5" -> typeCard = "MasterCard"
    "6" -> typeCard = "MaestroCard"
    else -> typeCard = "VK Pay"
}

//������ �������� � ����� ��������
calculationCommission(typeCard, previousSumma, amount)
println("������ ��������")

}

fun calculationCommission(typeCard: String, previousSumma: Double, amount: Float): Int {
    val procentKomissMaster = 0.6         // ������� �������� ���� Master
    val summaMinKomissMaster = 20         // ����� �������� Master
    val procentKomissVisaMir = 0.75       // ������� �������� ���� VISA / MIR
    val summaMinKomissVisaMir = 35.0      // ����� ��� �������� ���� VISA / MIR
    val maxLimitTodayCard = 150_000          // ������������ ����� � ����� �� ������ (����� VK Pay)
    val maxLimitMonthCard = 600_000          // ������������ ����� � ����� �� ������ (����� VK Pay)
    val maxLimitTodayVKPay = 15_000          // ������������ ����� � ����� VK Pay
    val maxLimitMonthVKPay = 40_000          // ������������ ����� � ����� VK Pay
    var summaTransfer = 0.0                  // ����� ��������
    var summaCommission = 0                  // ����� ��������

    println(typeCard) //������� �� ����� ��� �����

    if (typeCard == "VK Pay") {
        // �������� �� �������� ����� ��� ��������
        if (amount < maxLimitMonthVKPay) {
            // �������� �� �������� ����� ��� ��������
            if (amount < maxLimitTodayVKPay) {
                summaTransfer = amount - previousSumma
                println("����� ��������: $summaTransfer")
            } else {
                println("�������� �������� ����� �� ������� �� ����� VK Pay")
            }
        } else {
            println("�������� �������� ����� �� ������� �� ����� VK Pay")
        }
    }

    if ((amount + previousSumma) < maxLimitMonthCard) {
        if (amount < maxLimitTodayCard) {
            if (typeCard == "MIR Card" || typeCard == "VISA Card") {
                //������ ��������
                if ((amount / 100 * procentKomissVisaMir) < summaMinKomissVisaMir) {
                    summaTransfer = (amount - summaMinKomissVisaMir)
                    summaCommission = summaMinKomissVisaMir.toInt()
                } else {
                    summaTransfer = amount - (amount / 100 * procentKomissVisaMir)
                    summaCommission = (amount / 100 * procentKomissVisaMir).toInt()
                }
                println("����� ��������: $summaTransfer")
                println("����� ��������: $summaCommission")
            }

            if (typeCard == "MasterCard" || typeCard == "MaestroCard") {
                summaTransfer = (amount - (amount / 100 * procentKomissMaster)) - summaMinKomissMaster
                summaCommission = ((amount / 100 * procentKomissMaster) + summaMinKomissMaster).toInt()
                println("����� ��������: $summaCommission")
                println("����� ��������: $summaTransfer")
            }

        } else {
            println("�������� ����� �� ����� �� ����� �������� � �����")
        }

    } else {
        println("�������� ����� �� ����� �� ����� �������� � �����")
    }
    return summaCommission
}
