Function se_compile_var%(arg0.se_block)
    Local local0.se_node
    local0 = arg0\Field2\Field4[$01]
    While (local0 <> Null)
        If (local0\Field0\Field0 = $07) Then
            se_compilenode(local0)
        EndIf
        local0 = se_nextnode(local0)
        If (local0 = Null) Then
            Return $00
        EndIf
        If (local0\Field0\Field0 = $08) Then
            local0 = local0\Field8
        EndIf
    Wend
    Return $00
End Function
