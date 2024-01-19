Function se_compile_for%(arg0.se_block)
    Local local0.se_block
    Local local1.se_node
    Local local2.se_node
    Local local3.se_node
    Local local4.se_blockspace
    Local local5%
    Local local6.se_vf_value
    local0 = arg0\Field7
    local1 = local0\Field2
    local0 = local0\Field6
    local2 = local0\Field2
    local0 = local0\Field6
    local3 = local0\Field2
    local0 = local0\Field6
    local4 = se_pushblock(Null)
    local4\Field1 = se_vf_createlabel()
    If (local1 <> Null) Then
        If (se_compilenode(local1\Field4[$01]) = Null) Then
            se_poptemp()
        EndIf
    EndIf
    local4\Field1\Field1 = (Last se_vf_inst)
    local4\Field1\Field2 = $01
    If (local2 <> Null) Then
        local4\Field2 = se_vf_createlabel()
        local6 = se_compilenode(local2\Field4[$01])
        If (local6 = Null) Then
            local6 = se_poptemp()
        EndIf
        se_vf_createinst($1A, local6, se_vf_getlabel(local4\Field2), Null)
    EndIf
    While (local0 <> Null)
        se_compileblock(local0)
        local0 = local0\Field6
    Wend
    If (local3 <> Null) Then
        If (se_compilenode(local3\Field4[$01]) = Null) Then
            se_poptemp()
        EndIf
    EndIf
    If (local4\Field2 <> Null) Then
        local4\Field2\Field1 = se_vf_createinst($18, se_vf_getlabel(local4\Field1), Null, Null)
        local4\Field2\Field2 = $01
    Else
        se_vf_createinst($18, se_vf_getlabel(local4\Field1), Null, Null)
    EndIf
    se_popblock()
    Return $00
End Function
