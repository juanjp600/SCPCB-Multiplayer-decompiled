Function se_compile_return%(arg0.se_block)
    Local local0.se_node
    Local local1.se_vf_value
    local0 = arg0\Field2
    If (local0 <> Null) Then
        local1 = se_compilenode(arg0\Field2\Field4[$01])
        If (local1 = Null) Then
            local1 = se_poptemp()
        EndIf
        se_vf_createinst($1E, local1, Null, Null)
    Else
        se_vf_createinst($1F, local1, Null, Null)
    EndIf
    Return $00
End Function
