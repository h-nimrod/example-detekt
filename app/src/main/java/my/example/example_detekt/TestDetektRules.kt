package my.example.example_detekt

import java.util.*
import kotlin.collections.ArrayList // 不要なimport

// TODO: この機能を実装する（detektがTODOコメントを検出するかテスト）
// FIXME: バグを修正する（detektがFIXMEコメントを検出するかテスト）

class TestDetektRules {
    
    // 非常に長いパラメータリスト（detektが検出するはず）
    fun functionWithTooManyParameters(
        param1: String,
        param2: Int,
        param3: Boolean,
        param4: Double,
        param5: Float,
        param6: Long,
        param7: Char,
        param8: String
    ): String {
        return "$param1-$param2-$param3-$param4-$param5-$param6-$param7-$param8"
    }
    
    // 空のcatchブロック（detektが検出するはず）
    fun emptyExceptionHandling() {
        try {
            riskyOperation()
        } catch (e: Exception) {
            // 空のcatchブロック - detektが検出するはず
        }
    }
    
    // 複雑度の高いメソッド（Cyclomatic Complexity違反）
    fun complexMethod(input: Int): String {
        if (input > 100) {
            if (input > 200) {
                if (input > 300) {
                    if (input > 400) {
                        return "Very High"
                    } else {
                        return "High"
                    }
                } else {
                    if (input > 250) {
                        return "Medium High"
                    } else {
                        return "Medium"
                    }
                }
            } else {
                if (input > 150) {
                    return "Medium Low"
                } else {
                    return "Low Medium"
                }
            }
        } else {
            if (input > 50) {
                if (input > 75) {
                    return "Low High"
                } else {
                    return "Low"
                }
            } else {
                return "Very Low"
            }
        }
    }
    
    // マジックナンバーを大量に使用
    fun calculateWithMagicNumbers(value: Int): Int {
        return value * 42 + 123 - 789 + 456 * 3.14159.toInt() / 2.71828.toInt()
    }
    
    // 不適切な命名規則
    var bad_variable_name = "Should be camelCase"
    private val ANOTHER_BAD_NAME = "Should be lowercase for properties"
    
    // 長すぎるメソッド（60行を超えるようにする）
    fun veryLongMethod() {
        println("Line 1")
        println("Line 2")
        println("Line 3")
        println("Line 4")
        println("Line 5")
        println("Line 6")
        println("Line 7")
        println("Line 8")
        println("Line 9")
        println("Line 10")
        println("Line 11")
        println("Line 12")
        println("Line 13")
        println("Line 14")
        println("Line 15")
        println("Line 16")
        println("Line 17")
        println("Line 18")
        println("Line 19")
        println("Line 20")
        println("Line 21")
        println("Line 22")
        println("Line 23")
        println("Line 24")
        println("Line 25")
        println("Line 26")
        println("Line 27")
        println("Line 28")
        println("Line 29")
        println("Line 30")
        println("Line 31")
        println("Line 32")
        println("Line 33")
        println("Line 34")
        println("Line 35")
        println("Line 36")
        println("Line 37")
        println("Line 38")
        println("Line 39")
        println("Line 40")
        println("Line 41")
        println("Line 42")
        println("Line 43")
        println("Line 44")
        println("Line 45")
        println("Line 46")
        println("Line 47")
        println("Line 48")
        println("Line 49")
        println("Line 50")
        println("Line 51")
        println("Line 52")
        println("Line 53")
        println("Line 54")
        println("Line 55")
        println("Line 56")
        println("Line 57")
        println("Line 58")
        println("Line 59")
        println("Line 60")
        println("Line 61")
        println("This method is too long!")
    }
    
    // Unsafe cast使用
    fun unsafeCasting(obj: Any): String {
        return obj as String // unsafe cast - detektが検出するはず
    }
    
    // printStackTrace使用（detektが検出するはず）
    private fun riskyOperation() {
        try {
            throw RuntimeException("Test exception")
        } catch (e: Exception) {
            e.printStackTrace() // detektが検出するはず
        }
    }
    
    // 重複した文字列リテラル
    fun duplicateStrings() {
        println("This is a duplicate string")
        println("This is a duplicate string")
        println("This is a duplicate string")
        println("This is a duplicate string")
    }
} 