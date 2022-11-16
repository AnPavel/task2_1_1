import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @Test
    fun calculationCommissionMIR() {
        val typeCard = "MIR Card"
        val amount: Float = 10000.0F
        val previousSumma = 0.0

        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(175, result)
    }

    @Test
    fun calculationCommissionMIRmin() {
        val typeCard = "MIR Card"
        val amount: Float = 1000.0F
        val previousSumma: Double = 0.0

        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(135, result)
    }

    @Test
    fun calculationCommissionMIRLimit() {
        val typeCard = "MIR Card"
        val amount: Float = 150001.0F
        val previousSumma: Double = 0.0
        //ëèìèò â ñóòêè
        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(0, result)
    }

    @Test
    fun calculationCommissionMIRLimitM() {
        val typeCard = "MIR Card"
        val amount: Float = 600001.0F
        val previousSumma: Double = 0.0
        //ëèìèò â ìåñÿö
        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(0, result)
    }

    @Test
    fun calculationCommissionMasterCard() {
        val typeCard = "MasterCard"
        val amount: Float = 10000.0F
        val previousSumma = 0.0

        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(80, result)
    }

    @Test
    fun calculationCommissionMastercardmin() {
        val typeCard = "MasterCard"
        val amount: Float = 1000.0F
        val previousSumma: Double = 0.0

        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(26, result)
    }

    @Test
    fun calculationCommissionMastercardLimit() {
        val typeCard = "MasterCard"
        val amount: Float = 150001.0F
        val previousSumma: Double = 0.0
        //ëèìèò â ñóòêè
        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(0, result)
    }

    @Test
    fun calculationCommissionMastercardLimitM() {
        val typeCard = "MasterCard"
        val amount: Float = 600001.0F
        val previousSumma: Double = 0.0
        //ëèìèò â ìåñÿö
        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(0, result)
    }


    @Test
    fun calculationCommissionVKPay() {
        val typeCard = "VK Pay"
        val amount: Float = 1000.0F
        val previousSumma: Double = 0.0

        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(0, result)
    }

    @Test
    fun calculationCommissionVKPayLimit() {
        val typeCard = "VK Pay"
        val amount: Float = 15001.0F
        val previousSumma: Double = 0.0
        //ëèìèò â äåíü
        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(0, result)
    }

    @Test
    fun calculationCommissionVKPayLimitM() {
        val typeCard = "VK Pay"
        val amount: Float = 100000.0F
        val previousSumma: Double = 0.0
        //ëèìèò â ìåñÿö
        val result = calculationCommission(typeCard, previousSumma, amount)
        assertEquals(0, result)
    }



}
