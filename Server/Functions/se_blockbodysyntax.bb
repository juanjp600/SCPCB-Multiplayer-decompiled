Function se_blockbodysyntax%(arg0.se_block)
    While (arg0 <> Null)
        se_blocksyntax(arg0)
        If (se_error <> 0) Then
            Return $00
        EndIf
        arg0 = arg0\Field6
    Wend
    Return $00
End Function
