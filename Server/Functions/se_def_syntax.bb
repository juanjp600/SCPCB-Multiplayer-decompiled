Function se_def_syntax%(arg0.se_block)
    Local local0.se_node
    Local local1.se_token
    local0 = arg0\Field2\Field4[$01]
    se_function_def = se_getfunctiondef(local0\Field0\Field1)
    local0 = local0\Field4[$01]\Field4[$01]
    local1 = arg0\Field3
    Repeat
        If (local0\Field0\Field0 = $06) Then
            Exit
        ElseIf (local0\Field0\Field0 = $08) Then
            local0 = local0\Field8
        EndIf
        se_nodesyntax(local0)
        If (se_error <> 0) Then
            Return $00
        EndIf
        local0 = se_nextnode(local0)
    Forever
    se_pushblock(arg0)
    se_blockbodysyntax(arg0\Field7)
    If (se_error <> 0) Then
        Return $00
    EndIf
    se_popblock()
    Return $00
End Function
