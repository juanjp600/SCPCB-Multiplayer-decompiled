Function se_select_syntax%(arg0.se_block)
    Local local0.se_block
    Local local1%
    se_nodesyntax(arg0\Field2\Field4[$01])
    If (se_error <> 0) Then
        Return $00
    EndIf
    local0 = arg0\Field7
    If (local0 <> Null) Then
        If (local0\Field0 <> $08) Then
            se_error_expecting(local0\Field3, "'case'")
            Return $00
        EndIf
    Else
        se_error(arg0\Field3, "expecting at least one 'case'", $01)
        Return $00
    EndIf
    se_pushblock(local0)
    While (local0 <> Null)
        If (((local0\Field0 = $08) And local1) <> 0) Then
            se_error_unexpected(local0\Field3)
            Return $00
        EndIf
        If (local0\Field0 = $06) Then
            local1 = $01
        Else
            se_blocksyntax(local0)
            If (se_error <> 0) Then
                Return $00
            EndIf
        EndIf
        local0 = local0\Field6
    Wend
    se_popblock()
    Return $00
End Function
