Function se_compileblock%(arg0.se_block)
    Select arg0\Field0
        Case $01
            If (se_compilenode(arg0\Field2\Field4[$01]) = Null) Then
                se_poptemp()
            EndIf
        Case $03
            se_compile_var(arg0)
        Case $04
            se_compile_def(arg0)
        Case $05
            se_compile_if(arg0)
        Case $07
            se_compile_select(arg0)
        Case $09
            se_compile_for(arg0)
        Case $0A
            se_compile_while(arg0)
        Case $0B
            se_compile_do(arg0)
        Case $0D
            se_compile_break(arg0)
        Case $0E
            se_compile_continue(arg0)
        Case $0F
            se_compile_return(arg0)
    End Select
    Return $00
End Function
