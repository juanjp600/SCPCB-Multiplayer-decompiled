Function se_for_syntax%(arg0.se_block)
    Local local0.se_block
    Local local1%
    local0 = arg0\Field7
    If (local0\Field2 <> Null) Then
        se_nodesyntax(local0\Field2\Field4[$01])
        If (se_error <> 0) Then
            Return $00
        EndIf
    EndIf
    local0 = local0\Field6
    If (local0\Field2 <> Null) Then
        se_nodesyntax(local0\Field2\Field4[$01])
        If (se_error <> 0) Then
            Return $00
        EndIf
    EndIf
    local0 = local0\Field6
    If (local0\Field2 <> Null) Then
        se_nodesyntax(local0\Field2\Field4[$01])
        If (se_error <> 0) Then
            Return $00
        EndIf
    EndIf
    se_pushblock(arg0)
    se_blockbodysyntax(local0\Field6)
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_popblock()
    Return $00
End Function
