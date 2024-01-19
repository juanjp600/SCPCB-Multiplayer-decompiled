Function se_if_syntax%(arg0.se_block)
    se_nodesyntax(arg0\Field2\Field4[$01])
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_pushblock(arg0)
    se_blockbodysyntax(arg0\Field7)
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_popblock()
    Return $00
End Function
