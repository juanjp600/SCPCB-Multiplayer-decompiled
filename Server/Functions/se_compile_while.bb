Function se_compile_while%(arg0.se_block)
    Local local0.se_node
    Local local1.se_blockspace
    Local local2.se_block
    Local local3.se_vf_value
    local0 = arg0\Field2
    local1 = se_pushblock(Null)
    local1\Field1 = se_vf_createlabel()
    local1\Field2 = se_vf_createlabel()
    local2 = arg0\Field7
    local1\Field1\Field1 = (Last se_vf_inst)
    local1\Field1\Field2 = $01
    If (local0 <> Null) Then
        local3 = se_compilenode(local0\Field4[$01])
        If (local3 = Null) Then
            local3 = se_poptemp()
        EndIf
        se_vf_createinst($1A, local3, se_vf_getlabel(local1\Field2), Null)
    EndIf
    While (local2 <> Null)
        se_compileblock(local2)
        local2 = local2\Field6
    Wend
    local1\Field2\Field1 = se_vf_createinst($18, se_vf_getlabel(local1\Field1), Null, Null)
    local1\Field2\Field2 = $01
    se_popblock()
    Return $00
End Function
