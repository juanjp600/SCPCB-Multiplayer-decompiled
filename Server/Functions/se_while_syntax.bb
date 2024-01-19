Function se_while_syntax%(arg0.se_block)
    Local local0.se_node
    local0 = arg0\Field2\Field4[$01]
    se_nodesyntax(local0)
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
