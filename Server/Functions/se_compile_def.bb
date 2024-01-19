Function se_compile_def%(arg0.se_block)
    Local local0.se_node
    Local local1.se_vf_value
    Local local2.se_vf_label
    local0 = arg0\Field2\Field4[$01]
    se_function_def = se_getfunctiondef(local0\Field0\Field1)
    se_function_def\Field0\Field2 = (Last se_vf_inst)
    local0 = local0\Field4[$01]\Field4[$01]
    While (local0\Field0\Field0 <> $06)
        If (local0\Field0\Field0 = $07) Then
            local2 = se_vf_createlabel()
            local1 = se_getvariable(local0\Field4[$00]\Field0\Field1)
            se_vf_createinst($1A, local1, se_vf_getlabel(local2), Null)
            se_compilenode(local0)
            local2\Field1 = (Last se_vf_inst)
            local2\Field2 = $01
        EndIf
        local0 = se_nextnode(local0)
        If (local0\Field0\Field0 = $08) Then
            local0 = local0\Field8
        EndIf
    Wend
    arg0 = arg0\Field7
    While (arg0 <> Null)
        se_compileblock(arg0)
        arg0 = arg0\Field6
    Wend
    se_vf_createinst($1F, Null, Null, Null)
    If (se_function_def\Field0\Field2 = Null) Then
        se_function_def\Field0\Field2 = (First se_vf_inst)
    Else
        se_function_def\Field0\Field2 = (After se_function_def\Field0\Field2)
    EndIf
    se_function_def\Field0\Field3 = (Last se_vf_inst)
    Return $00
End Function
