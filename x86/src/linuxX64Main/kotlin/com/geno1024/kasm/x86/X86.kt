package com.geno1024.kasm.x86

import com.geno1024.kasm.x86.X86.Imm.Imm16
import com.geno1024.kasm.x86.X86.Imm.Imm8
import com.geno1024.kasm.x86.X86.Register.*
import com.geno1024.kasm.x86.X86.Register.Companion.AL

@ExperimentalUnsignedTypes
object X86
{
    open class Register(reg: UInt)
    {
        class R8(reg: UInt) : Register(reg)
        class R16(reg: UInt) : Register(reg)
        class R32(reg: UInt) : Register(reg)

        companion object
        {
            val AL = R8(0U)
            val CL = R8(1U)
            val DL = R8(2U)
            val BL = R8(3U)
            val AH = R8(4U)
            val CH = R8(5U)
            val DH = R8(6U)
            val BH = R8(7U)
            val SPL = R8(4U)
            val BPL = R8(5U)
            val SIL = R8(4U)
            val DIL = R8(5U)

            val AX = R16(0U)
            val CX = R16(1U)
            val DX = R16(2U)
            val BX = R16(3U)
            val SP = R16(4U)
            val BP = R16(5U)
            val SI = R16(6U)
            val DI = R16(7U)

            val EAX = R32(0U)
            val ECX = R32(1U)
            val EDX = R32(2U)
            val EBX = R32(3U)
            val ESP = R32(4U)
            val EBP = R32(5U)
            val ESI = R32(6U)
            val EDI = R32(7U)
        }
    }

    open class Imm(open val value: UByteArray)
    {
        class Imm8(value: Byte) : Imm(ubyteArrayOf(value.toUByte()))
        class Imm16(value: UShort) : Imm(ubyteArrayOf(
            (value and 255U).toUByte(),
            ((value and 0xFF00U).toUInt() shr 8).toUByte() // why?
        ))
        class Imm32(value: UInt) : Imm(ubyteArrayOf(
            (value and 255U).toUByte(),
            (value shr 8 and 255U).toUByte(),
            (value shr 16 and 255U).toUByte(),
            (value shr 24 and 255U).toUByte(),
        ))
        class Imm64(value: ULong) : Imm(ubyteArrayOf(
            (value and 255U).toUByte(),
            (value shr 8 and 255U).toUByte(),
            (value shr 16 and 255U).toUByte(),
            (value shr 24 and 255U).toUByte(),
            (value shr 32 and 255U).toUByte(),
            (value shr 40 and 255U).toUByte(),
            (value shr 48 and 255U).toUByte(),
            (value shr 56 and 255U).toUByte(),
        ))
    }

    open class Line
    {
        abstract class Instruction : Line()
        {
            abstract fun assemble(): UByteArray

            fun size() = assemble().size
        }

        class ADD : Instruction
        {
            private val opcode: UByteArray

            constructor(r8: R8, imm8: Imm8)
            {
                opcode = if (r8 == AL)
                    ubyteArrayOf(4U, *imm8.value)
                else
                    ubyteArrayOf()
            }

            constructor(r16: R16, imm16: Imm16)
            {
                opcode = ubyteArrayOf()
            }

            override fun assemble(): UByteArray = opcode
        }
    }

    fun assemble(vararg line: Line): List<UByteArray>
    {
        TODO()
    }
}
