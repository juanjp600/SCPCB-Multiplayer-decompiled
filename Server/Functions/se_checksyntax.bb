Function se_checksyntax%()
    Local local0.se_block
    local0 = se_root_block\Field7
    While (local0 <> Null)
        se_blocksyntax(local0)
        If (se_error <> 0) Then
            Return $00
        EndIf
        local0 = local0\Field6
    Wend
    Return $00
End Function
