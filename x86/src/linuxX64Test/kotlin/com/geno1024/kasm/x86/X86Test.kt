package com.geno1024.kasm.x86

import com.geno1024.kasm.x86.X86.Imm.Imm8
import com.geno1024.kasm.x86.X86.Register.Companion.EAX
import com.geno1024.kasm.x86.X86.Line.ADD
import com.geno1024.kasm.x86.X86.Register.Companion.AL
import kotlin.test.Test

@ExperimentalUnsignedTypes
class X86Test
{
    @Test
    fun simple()
    {
        X86.assemble(
            ADD(AL, Imm8(4))
        )
    }

/*    @Test
    fun helloworld()
    {
        X86.assembly(
            SECTION(".data") {

            },
            SECTION(".text") {

            },
            LABEL("_start"),
            MOV(EAX, 4)
        )
        /*
; Define variables in the data section
SECTION .DATA
hello:     db 'Hello world!',10
helloLen:  equ $-hello

; Code goes in the text section
SECTION .TEXT
GLOBAL _start

_start:
mov eax,4            ; 'write' system call = 4
mov ebx,1            ; file descriptor 1 = STDOUT
mov ecx,hello        ; string to write
mov edx,helloLen     ; length of string to write
int 80h              ; call the kernel

; Terminate program
mov eax,1            ; 'exit' system call
mov ebx,0            ; exit with error code 0
int 80h              ; call the kernel
 */
    }*/
}
