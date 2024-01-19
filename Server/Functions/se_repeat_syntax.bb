Function se_repeat_syntax%(arg0.se_block)
    If (arg0\Field2 <> Null) Then
        se_nodesyntax(arg0\Field2\Field4[$01])
        If (se_error <> 0) Then
            Return $00
        EndIf
    EndIf
    Return $00
End Function
