Function se_compile_do%(arg0.se_block)
    Local local0.se_blockspace
    Local local1.se_block
    Local local2.se_node
    Local local3.se_vf_value
    local0 = se_pushblock(Null)
    local0\Field1 = se_vf_createlabel()
    local1 = arg0\Field7
    local0\Field1\Field1 = (Last se_vf_inst)
    local0\Field1\Field2 = $01
    While (local1 <> Null)
        If (local1\Field0 = $0C) Then
            Exit
        EndIf
        se_compileblock(local1)
        local1 = local1\Field6
    Wend
    If (local1 = Null) Then
        se_vf_createinst($18, se_vf_getlabel(local0\Field1), Null, Null)
    Else
        local2 = local1\Field2
        If (local2 <> Null) Then
            local0\Field2 = se_vf_createlabel()
            local3 = se_compilenode(local2\Field4[$01])
            If (local3 = Null) Then
                local3 = se_poptemp()
            EndIf
            se_vf_createinst($19, local3, se_vf_getlabel(local0\Field1), Null)
        EndIf
    EndIf
    If (local0\Field2 <> Null) Then
        local0\Field2\Field1 = (Last se_vf_inst)
        local0\Field2\Field2 = $01
    Else
        se_vf_createinst($18, se_vf_getlabel(local0\Field1), Null, Null)
    EndIf
    se_popblock()
    Return $00
End Function
