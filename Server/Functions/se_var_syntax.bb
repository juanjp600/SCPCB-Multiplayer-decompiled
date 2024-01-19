Function se_var_syntax%(arg0.se_block)
    Local local0.se_node
    Local local1.se_token
    local0 = arg0\Field2\Field4[$01]
    local1 = arg0\Field3
    Repeat
        If (local0 = Null) Then
            se_error_eol(local1)
            Return $00
        EndIf
        se_nodesyntax(local0)
        If (se_error <> 0) Then
            Return $00
        EndIf
        local1 = local0\Field0
        local0 = se_nextnode(local0)
        If (local0 = Null) Then
            Exit
        ElseIf (local0\Field0\Field0 = $08) Then
            local0 = local0\Field8
        Else
            se_error_unexpected(local0\Field0)
            Return $00
        EndIf
    Forever
    Return $00
End Function
