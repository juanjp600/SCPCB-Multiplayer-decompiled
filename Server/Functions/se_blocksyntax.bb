Function se_blocksyntax%(arg0.se_block)
    Select arg0\Field0
        Case $01
            se_nodesyntax(arg0\Field2\Field4[$01])
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $03
            se_var_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $04
            se_def_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $05
            se_if_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $06
            se_else_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $07
            se_select_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $08
            se_case_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $09
            se_for_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $0A
            se_while_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $0B
            se_do_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $0C
            se_repeat_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $0D
            se_break_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $0E
            se_continue_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        Case $0F
            se_return_syntax(arg0)
            If (se_error <> 0) Then
                Return $00
            EndIf
    End Select
    Return $00
End Function
