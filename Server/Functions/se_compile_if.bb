Function se_compile_if%(arg0.se_block)
    Local local0.se_block
    Local local1%
    Local local2.se_node
    Local local3.se_vf_value
    Local local4.se_vf_label
    Local local5.se_vf_label
    local0 = arg0\Field7
    While (local0 <> Null)
        If (local0\Field0 = $06) Then
            local1 = (local1 + $01)
        EndIf
        local0 = local0\Field6
    Wend
    local2 = arg0\Field2\Field4[$01]
    local4 = se_vf_createlabel()
    If (local1 <> 0) Then
        local5 = se_vf_createlabel()
    EndIf
    local0 = arg0\Field7
    Repeat
        If (local2 <> Null) Then
            local3 = se_compilenode(local2)
            If (local3 = Null) Then
                local3 = se_poptemp()
            EndIf
            If (local1 <> 0) Then
                se_vf_createinst($1A, local3, se_vf_getlabel(local5), Null)
            Else
                se_vf_createinst($1A, local3, se_vf_getlabel(local4), Null)
            EndIf
            local2 = Null
        EndIf
        While (local0 <> Null)
            If (local0\Field0 = $06) Then
                If (local0\Field2 <> Null) Then
                    local2 = local0\Field2\Field4[$01]
                EndIf
                local0 = local0\Field6
                Exit
            EndIf
            se_compileblock(local0)
            local0 = local0\Field6
        Wend
        If (local0 = Null) Then
            local4\Field1 = (Last se_vf_inst)
            local4\Field2 = $01
            Exit
        EndIf
        se_vf_createinst($18, se_vf_getlabel(local4), Null, Null)
        local5\Field1 = (Last se_vf_inst)
        local5\Field2 = $01
        local1 = (local1 - $01)
        If (local1 <> 0) Then
            local5 = se_vf_createlabel()
        EndIf
    Forever
    Return $00
End Function
