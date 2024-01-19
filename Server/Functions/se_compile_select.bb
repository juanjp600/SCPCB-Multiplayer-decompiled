Function se_compile_select%(arg0.se_block)
    Local local0.se_block
    Local local1%
    Local local2.se_vf_value
    Local local3.se_vf_value
    Local local4.se_node
    Local local5.se_vf_value
    Local local6.se_vf_value
    Local local7.se_vf_label
    Local local8.se_vf_label
    Local local9.se_vf_label
    local0 = arg0\Field7
    While (local0 <> Null)
        If (((local0\Field0 = $08) Or (local0\Field0 = $06)) <> 0) Then
            local1 = (local1 + $01)
        EndIf
        local0 = local0\Field6
    Wend
    local2 = se_compilenode(arg0\Field2\Field4[$01])
    If (local2 = Null) Then
        local2 = se_poptemp()
    EndIf
    local3 = se_pushtemp()
    se_vf_createinst($01, local3, local2, Null)
    local0 = arg0\Field7
    local4 = local0\Field2
    local6 = se_pushtemp()
    local7 = se_vf_createlabel()
    Repeat
        If (local0\Field0 = $08) Then
            If (local8 <> Null) Then
                local8\Field1 = (Last se_vf_inst)
                local8\Field2 = $01
            EndIf
            local1 = (local1 - $01)
            If (local1 <> 0) Then
                local8 = se_vf_createlabel()
            EndIf
            local9 = Null
            local4 = local0\Field2\Field4[$01]
            local6 = se_pushtemp()
            Repeat
                local5 = se_compilenode(local4)
                If (local5 = Null) Then
                    local5 = se_poptemp()
                EndIf
                local4 = se_nextnode(local4)
                se_vf_createinst($0B, local3, local5, local6)
                If (local4 = Null) Then
                    If (local1 <> 0) Then
                        se_vf_createinst($1A, local6, se_vf_getlabel(local8), Null)
                    Else
                        se_vf_createinst($1A, local6, se_vf_getlabel(local7), Null)
                    EndIf
                    If (local9 <> Null) Then
                        local9\Field1 = (Last se_vf_inst)
                        local9\Field2 = $01
                    EndIf
                    Exit
                Else
                    local4 = local4\Field8
                    If (local9 = Null) Then
                        local9 = se_vf_createlabel()
                    EndIf
                    se_vf_createinst($19, local6, se_vf_getlabel(local9), Null)
                EndIf
            Forever
            se_poptemp()
            local0 = local0\Field6
        ElseIf (local0\Field0 = $06) Then
            local8\Field1 = (Last se_vf_inst)
            local8\Field2 = $01
            local0 = local0\Field6
        EndIf
        While (local0 <> Null)
            If (((local0\Field0 = $08) Or (local0\Field0 = $06)) <> 0) Then
                Exit
            EndIf
            se_compileblock(local0)
            local0 = local0\Field6
        Wend
        If (local0 = Null) Then
            local7\Field1 = (Last se_vf_inst)
            local7\Field2 = $01
            Exit
        EndIf
        se_vf_createinst($18, se_vf_getlabel(local7), Null, Null)
    Forever
    Return $00
End Function
